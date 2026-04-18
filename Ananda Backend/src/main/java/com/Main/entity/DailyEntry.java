package com.Main.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@Table(name = "daily_entry_items")
public class DailyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daily_entry_id")
    private Long dailyEntryId;

    @ManyToOne
    @JoinColumn(name = "daily_item_total_id")
    private DailyItemTotal dailyItemTotal;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemMaster item;

    @Column(name = "previous_day_qty")
    private Integer previousQty;

    @Column(name = "today_qty")
    private Integer todayQty;

    @Column(name = "total_qty")
    private Integer todaySold;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;
}