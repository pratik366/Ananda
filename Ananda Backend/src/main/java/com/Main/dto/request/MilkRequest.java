package com.Main.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MilkRequest {

    private BigDecimal milkPaidAmount;
    private BigDecimal pendingMilkLiters;
    private BigDecimal usedMilkLiters;
}