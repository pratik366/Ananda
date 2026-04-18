package com.Main.Mapper;

import java.util.List;
import org.springframework.stereotype.Component;

import com.Main.dto.response.DailyEntryResponse;
import com.Main.dto.response.DailyItemResponse;
import com.Main.entity.DailyEntry;
import com.Main.entity.DailyItemTotal;

@Component
public class DailyEntryMapper {

    public DailyEntryResponse toResponse(DailyItemTotal header) {

        List<DailyItemResponse> items = header.getEntries().stream()
                .map(entry -> DailyItemResponse.builder()
                        .itemName(entry.getItem().getItemName())
                        .previousQty(entry.getPreviousQty())   
                        .todayQty(entry.getTodayQty())
                        .todaySold(entry.getTodaySold())       
                        .totalAmount(entry.getTotalAmount())
                        .build()
                )
                .toList();

        return DailyEntryResponse.builder()
                .entryDate(header.getEntryDate())
                .grandTotal(header.getGrandTotal())
                .items(items)
                .build();
    }
}
