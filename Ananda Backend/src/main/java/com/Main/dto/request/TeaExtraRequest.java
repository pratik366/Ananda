package com.Main.dto.request;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeaExtraRequest {

    private BigDecimal pendingExtra;
    private BigDecimal freeExtra;
    private BigDecimal wasteExtra;
}
