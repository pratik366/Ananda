package com.Main.dto.request;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor      
@AllArgsConstructor
public class DailyEntryRequest {

    private LocalDate entryDate;
    private List<dailyItemRequest> items;
}
