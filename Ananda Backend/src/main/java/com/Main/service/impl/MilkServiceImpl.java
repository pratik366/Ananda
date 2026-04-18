package com.Main.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.Main.Mapper.MilkMapper;
import com.Main.dto.request.MilkRequest;
import com.Main.dto.response.MilkResponse;
import com.Main.entity.Milk;
import com.Main.repository.MilkRepository;
import com.Main.service.MilkService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MilkServiceImpl implements MilkService {

    private final MilkMapper milkMapper;
    private final MilkRepository milkRepository;

    @Override
    public MilkResponse createMilk(MilkRequest request) {

        Milk milk = new Milk();

        milk.setMilkPaidAmount(
            request.getMilkPaidAmount() != null ? request.getMilkPaidAmount() : BigDecimal.ZERO
        );
        milk.setPendingMilkLiters(
            request.getPendingMilkLiters() != null ? request.getPendingMilkLiters() : BigDecimal.ZERO
        );
        milk.setUsedMilkLiters(
            request.getUsedMilkLiters() != null ? request.getUsedMilkLiters() : BigDecimal.ZERO
        );

        Milk saved = milkRepository.save(milk);

        return milkMapper.toResponse(saved);
}

}
