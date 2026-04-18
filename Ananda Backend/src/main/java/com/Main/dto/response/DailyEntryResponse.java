package com.Main.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.Main.entity.DailyItemTotal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DailyEntryResponse {

    private LocalDate entryDate;
    private BigDecimal grandTotal;
    private List<DailyItemResponse> items;

}
