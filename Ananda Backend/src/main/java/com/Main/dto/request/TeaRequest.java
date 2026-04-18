package com.Main.dto.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeaRequest {

  private List<TeaInput> teas;
    
    private BigDecimal pendingExtra;
    private BigDecimal freeExtra;
    private BigDecimal wasteExtra;
}
