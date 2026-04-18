package com.Main.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.Main.Mapper.PaymentMapper;
import com.Main.dto.request.PaymentRequest;
import com.Main.dto.response.PaymentResponse;
import com.Main.entity.Payment;
import com.Main.repository.PaymentRepository;
import com.Main.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        
        Payment payment= new Payment();

        BigDecimal total= paymentRequest.getCashPayment().add(paymentRequest.getCashPayment());

        payment.setCashPayment(paymentRequest.getCashPayment());
        payment.setOnlinePayment(paymentRequest.getCashPayment());
        payment.setExpenditure(paymentRequest.getExpenditure());
        payment.setTotalAmount(total);
        
        Payment savedPayment=paymentRepository.save(payment);

        return paymentMapper.toResponse(savedPayment);
    }

}
