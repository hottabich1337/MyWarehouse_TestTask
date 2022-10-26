package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import lombok.Data;

import java.util.List;

@Data
public class SaleDto {
    private  Long number;
    private Long warehouseId;
    private List<OperationItemDto> productList;
}
