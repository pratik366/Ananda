package com.Main.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "milk")
public class Milk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milk_id")
    private Long milkId;

    @Column(name = "milk_paid_amount")
    private BigDecimal milkPaidAmount;

    @Column(name = "pending_milk_liters")
    private BigDecimal pendingMilkLiters;

    @Column(name = "used_milk_liters")
    private BigDecimal usedMilkLiters;

    @Column(name = "entry_date")
    @CreationTimestamp
    private LocalDate entryDate;

    @Column(name = "entry_time")
    @CreationTimestamp
    private LocalTime entryTime;
}