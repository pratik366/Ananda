package com.Main.Mapper;

import org.springframework.stereotype.Component;

import com.Main.dto.response.PaymentResponse;
import com.Main.entity.Payment;

@Component
public class PaymentMapper {
    public PaymentResponse toResponse(Payment payment){

        return PaymentResponse.builder()
        .paymentId(payment.getPaymentID())
        .cashPayment(payment.getCashPayment())
        .onlinePayment(payment.getOnlinePayment())
        .expenditure(payment.getExpenditure())
        .totalAmount(payment.getTotalAmount())
        .build();
        
    }
}
