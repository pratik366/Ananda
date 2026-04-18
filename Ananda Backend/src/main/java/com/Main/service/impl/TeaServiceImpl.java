package com.Main.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Main.Mapper.TeaMapper;
import com.Main.constant.TeaInputType;
import com.Main.dto.request.TeaInput;
import com.Main.dto.request.TeaRequest;
import com.Main.dto.response.TeaResponse;
import com.Main.entity.Tea;
import com.Main.entity.TeaExtra;
import com.Main.entity.TeaMaster;
import com.Main.repository.TeaExtraRepository;
import com.Main.repository.TeaMasterRepository;
import com.Main.repository.TeaRepository;
import com.Main.service.TeaService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeaServiceImpl implements TeaService{

    private final TeaRepository teaRepository;
    private final TeaMasterRepository teaMasterRepository;
    private final TeaExtraRepository teaExtraRepository;

    @Override
    @Transactional
    public TeaResponse createTea(TeaRequest request) {

        TeaMaster master = teaMasterRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Tea master not found"));

        Tea tea = new Tea();
        tea.setTeaMaster(master);

        boolean hasQuantity = false;

        for (TeaInput input : request.getTeas()) {

            String type = input.getTeaType();
            BigDecimal value = input.getValue();

            if (input.getInputType() == TeaInputType.AMOUNT) {
                updateMaster(master, type, value);
            } else {
                BigDecimal price = getPrice(master, type);

                if (price == null || price.compareTo(BigDecimal.ZERO) == 0) {
                    throw new RuntimeException("Invalid price for " + type);
                }

                BigDecimal amount = value.multiply(price);

                // 🔥 ADD EXTRA LOGIC
                if ("pending_tea".equals(type) && request.getPendingExtra() != null) {
                    amount = amount.add(request.getPendingExtra());
                }
                if ("free_tea".equals(type) && request.getFreeExtra() != null) {
                    amount = amount.add(request.getFreeExtra());
                }
                if ("waste_tea".equals(type) && request.getWasteExtra() != null) {
                    amount = amount.add(request.getWasteExtra());
                }

                setTeaValue(tea, type, amount);
                hasQuantity = true;
            }
        }

        teaMasterRepository.save(master);

        Tea savedTea = null;

        if (hasQuantity) {
            savedTea = teaRepository.save(tea);

            // ✅ Save Extras Table
            TeaExtra extra = new TeaExtra();
            extra.setTea(savedTea);
            extra.setPendingExtra(request.getPendingExtra());
            extra.setFreeExtra(request.getFreeExtra());
            extra.setWasteExtra(request.getWasteExtra());

            teaExtraRepository.save(extra);
        }

        return mapToResponse(savedTea);
    }

    private BigDecimal getPrice(TeaMaster master, String type) {
        switch (type) {
            case "pending_tea": return master.getPendingTea();
            case "free_tea": return master.getFreeTea();
            case "waste_tea": return master.getWasteTea();
            case "lemon_tea": return master.getLemonTea();
            case "black_tea": return master.getBlackTea();
            default: throw new RuntimeException("Invalid tea type: " + type);
        }
    }

    private void updateMaster(TeaMaster master, String type, BigDecimal value) {
        switch (type) {
            case "pending_tea": master.setPendingTea(value); break;
            case "free_tea": master.setFreeTea(value); break;
            case "waste_tea": master.setWasteTea(value); break;
            case "lemon_tea": master.setLemonTea(value); break;
            case "black_tea": master.setBlackTea(value); break;
        }
    }

    private void setTeaValue(Tea tea, String type, BigDecimal value) {
        switch (type) {
            case "pending_tea": tea.setPendingTea(value); break;
            case "free_tea": tea.setFreeTea(value); break;
            case "waste_tea": tea.setWasteTea(value); break;
            case "lemon_tea": tea.setLemonTea(value); break;
            case "black_tea": tea.setBlackTea(value); break;
        }
    }

    private TeaResponse mapToResponse(Tea tea) {
        if (tea == null) return null;

        return TeaResponse.builder()
                .teaId(tea.getTeaId())
                .pendingTea(tea.getPendingTea())
                .freeTea(tea.getFreeTea())
                .wasteTea(tea.getWasteTea())
                .lemonTea(tea.getLemonTea())
                .blackTea(tea.getBlackTea())
                .build();
    }
}
