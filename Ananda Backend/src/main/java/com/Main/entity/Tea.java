package com.Main.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "tea_types")
public class Tea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tea_id")
    private Long teaId;

    private BigDecimal pendingTea;
    private BigDecimal freeTea;
    private BigDecimal wasteTea;
    private BigDecimal lemonTea;
    private BigDecimal blackTea;

    @CreationTimestamp
    private LocalDate date;

    @CreationTimestamp
    private LocalTime time;

    // 🔗 Link to master
    @ManyToOne
    @JoinColumn(name = "master_id")
    private TeaMaster teaMaster;

}
