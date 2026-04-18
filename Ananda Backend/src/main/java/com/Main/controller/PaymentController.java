package com.Main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Main.dto.request.PaymentRequest;
import com.Main.dto.response.PaymentResponse;
import com.Main.service.impl.PaymentServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/payment")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentServiceImpl paymentServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest) {
        try{
            PaymentResponse response = paymentServiceImpl.createPayment(paymentRequest);
            return ResponseEntity.ok(response);
        }catch(Exception e){
             throw new RuntimeException(e.getMessage());
        }
    }
    
}
