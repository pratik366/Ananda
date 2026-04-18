package com.Main.service;

import com.Main.dto.request.PaymentRequest;
import com.Main.dto.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);
}
