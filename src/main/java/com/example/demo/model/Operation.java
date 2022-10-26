package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="operation")
public class Operation {
    @Id
    private Long id;
    @Column(name = "operation_number")
    private Long operationNumber;
    @Column(name = "operation_type")
    private OperationType operationType;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "warehouse_from")
    private Long warehouseFrom;
    @Column(name = "warehouse_to")
    private Long warehouseTo;
    @Column(name=("product_id"))
    private Long productId;
    @Column(name=("count"))
    private Long count;
}

