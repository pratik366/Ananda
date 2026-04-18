package com.Main.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeaResponse {

    private Long teaId;
    private BigDecimal pendingTea;
    private BigDecimal freeTea;
    private BigDecimal wasteTea;
    private BigDecimal lemonTea;
    private BigDecimal blackTea;
}

