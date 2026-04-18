package com.Main.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tea_master")
public class TeaMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal pendingTea;
    private BigDecimal freeTea;
    private BigDecimal wasteTea;
    private BigDecimal lemonTea;
    private BigDecimal blackTea;
}
