package com.Main.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "payments")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentID;

    @Column(name = "cash_payment_type")
    private BigDecimal cashPayment;

    @Column( name = "online_payment_type" )
    private BigDecimal onlinePayment;

    @Column( name = "expenditure")
    private BigDecimal expenditure;

    @Column( name = "daily_total")
    private BigDecimal totalAmount;

    @Column(name = "payment_date")
    @CreationTimestamp
    private LocalDate paymentDate;

    @Column(name = "payment_time")
    @CreationTimestamp
    private LocalTime paymentTime;

}
