package com.Main.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "items_master")
@Getter
@Setter
public class ItemMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name", unique = true)
    private String itemName;

    @Column(name = "price")
    private BigDecimal price;
    
}