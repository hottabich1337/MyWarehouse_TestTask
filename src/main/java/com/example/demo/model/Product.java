package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    private Long article;
    @Column(name="name")
    private String name;
    @Column(name="last_purchase_price")
    private BigDecimal lastPurchasePrice;
    @Column(name="last_sale_price")
    private BigDecimal lastSalePrice;
}
