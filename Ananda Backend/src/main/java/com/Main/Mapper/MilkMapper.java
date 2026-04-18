package com.Main.Mapper;

import org.springframework.stereotype.Component;

import com.Main.dto.response.MilkResponse;
import com.Main.entity.Milk;

@Component
public class MilkMapper {

    public MilkResponse toResponse(Milk milk) {

        return MilkResponse.builder()
                .milkId(milk.getMilkId())
                .milkPaidAmount(milk.getMilkPaidAmount())
                .pendingMilkLiters(milk.getPendingMilkLiters())
                .usedMilkLiters(milk.getUsedMilkLiters())
                .entryDate(milk.getEntryDate())
                .entryTime(milk.getEntryTime())
                .build();
    }
}