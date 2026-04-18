package com.Main.dto.response;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public class DailyItemResponse {
    private String itemName;
    private Integer previousQty;
    private Integer todayQty;
    private Integer todaySold;
    private BigDecimal totalAmount;
}
