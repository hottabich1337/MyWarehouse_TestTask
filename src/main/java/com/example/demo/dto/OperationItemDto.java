package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OperationItemDto {
    private Long article;
    private Integer count;
    private BigDecimal price;
}
