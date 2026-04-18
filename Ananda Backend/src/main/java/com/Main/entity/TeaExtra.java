package com.Main.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tea_extra")
public class TeaExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal pendingExtra;
    private BigDecimal freeExtra;
    private BigDecimal wasteExtra;

    // 🔗 Link to Tea
    @OneToOne
    @JoinColumn(name = "tea_id")
    private Tea tea;
}
