package com.Main.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MilkResponse {

    private Long milkId;
    private BigDecimal milkPaidAmount;
    private BigDecimal pendingMilkLiters;
    private BigDecimal usedMilkLiters;
    private LocalDate entryDate;
    private LocalTime entryTime;
}