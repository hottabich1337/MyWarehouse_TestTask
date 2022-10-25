package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name="warehouse")
public class Warehouse {
    @Id
    private Long id;
    @Column(name=("name"))
    private String name;
    @ManyToMany
    @JoinTable(name="warehouse_products",joinColumns = @JoinColumn(name = "warehouse_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


}
