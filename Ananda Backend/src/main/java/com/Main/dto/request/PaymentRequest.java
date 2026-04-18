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
public class PaymentRequest {
    private BigDecimal cashPayment;
     private BigDecimal onlinePayment;
     private BigDecimal expenditure;
}
