package com.Main.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Main.dto.request.DailyEntryRequest;
import com.Main.dto.request.dailyItemRequest;
import com.Main.dto.response.DailyEntryResponse;
import com.Main.dto.response.DailyItemResponse;
import com.Main.entity.DailyEntry;
import com.Main.entity.DailyItemTotal;
import com.Main.entity.ItemMaster;
import com.Main.repository.DailyEntryRepository;
import com.Main.repository.DailyItemTotalRepository;
import com.Main.repository.ItemMasterRepository;
import com.Main.service.DailyEntryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyEntryServiceImpl implements DailyEntryService {

    private final DailyEntryRepository dailyEntryRepository;
    private final DailyItemTotalRepository headerRepository;
    private final ItemMasterRepository itemMasterRepository;

    @Override
    public DailyEntryResponse createEntry(DailyEntryRequest request) {

        LocalDate today = request.getEntryDate();
        LocalDate yesterday = today.minusDays(1);

        DailyItemTotal header = new DailyItemTotal();
        header.setEntryDate(today);
        header.setCreatedAt(LocalDateTime.now());

        BigDecimal grandTotal = BigDecimal.ZERO;

        List<DailyEntry> entries = new ArrayList<>();
        List<DailyItemResponse> responseItems = new ArrayList<>();

        for (dailyItemRequest itemRequest : request.getItems()) {

            // ✅ Get Item
            ItemMaster item = itemMasterRepository.findById(itemRequest.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            // ✅ Get Previous Day Qty (from yesterday total sold)
            Integer previousQty = dailyEntryRepository
                    .findByItem_ItemIdAndDailyItemTotal_EntryDate(item.getItemId(), yesterday)
                    .map(e -> e.getTodaySold())   // 🔥 UPDATED FIELD
                    .orElse(0);

            Integer todayQty = itemRequest.getTodayQty();

            // ✅ take todaySold from request
            Integer todaySold = itemRequest.getTodaySold();

            // ✅ calculate amount
            BigDecimal totalAmount =
                    item.getPrice().multiply(BigDecimal.valueOf(todaySold));

            // ✅ Create Entry
            DailyEntry entry = new DailyEntry();
            entry.setDailyItemTotal(header);
            entry.setItem(item);
            entry.setPreviousQty(previousQty);   // 🔥 UPDATED
            entry.setTodayQty(todayQty);
            entry.setTodaySold(todaySold);       // 🔥 UPDATED
            entry.setTotalAmount(totalAmount);

            entries.add(entry);

            // ✅ Add to grand total
            grandTotal = grandTotal.add(totalAmount);

            // ✅ Response
            responseItems.add(
                    DailyItemResponse.builder()
                            .itemName(item.getItemName())
                            .previousQty(previousQty)
                            .todayQty(todayQty)
                            .totalQty(todaySold)   // (keep response same UI name)
                            .totalAmount(totalAmount)
                            .build()
            );
        }

        // ✅ Save Header
        header.setGrandTotal(grandTotal);
        header.setEntries(entries);

        headerRepository.save(header);

        return DailyEntryResponse.builder()
                .entryDate(today)
                .grandTotal(grandTotal)
                .items(responseItems)
                .build();
    }
}