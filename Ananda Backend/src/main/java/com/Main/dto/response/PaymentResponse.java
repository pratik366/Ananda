package com.Main.dto.response;

import java.math.BigDecimal;

import com.Main.constant.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Long paymentId;
    private BigDecimal cashPayment;
    private BigDecimal onlinePayment;
    private BigDecimal expenditure;
    private BigDecimal totalAmount;
}
