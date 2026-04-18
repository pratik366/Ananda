package com.Main.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "daily_item_total")
public class DailyItemTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_item_total_id")
    private Long dailyItemTotalId;

    @Column(name = "entry_date", unique = true)
    private LocalDate entryDate;

    @Column(name = "grand_total")
    private BigDecimal grandTotal;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "dailyItemTotal", cascade = CascadeType.ALL)
    private List<DailyEntry> entries;
}