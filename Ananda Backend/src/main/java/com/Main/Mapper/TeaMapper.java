package com.Main.Mapper;

import org.springframework.stereotype.Component;

import com.Main.dto.response.TeaResponse;
import com.Main.entity.Tea;

@Component
public class TeaMapper {

    public TeaResponse toResponse(Tea tea){
        return TeaResponse.builder()
                .blackTea(tea.getBlackTea())
                .freeTea(tea.getFreeTea())
                .wasteTea(tea.getWasteTea())
                .lemonTea(tea.getLemonTea())
                .pendingTea(tea.getPendingTea())
                .build();
    }
}
