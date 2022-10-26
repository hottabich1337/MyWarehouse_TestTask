package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import lombok.Data;

import java.util.List;

@Data
public class MovingDto {
    private  Long number;
    private Long warehouseId1;
    private Long warehouseId2;
    private List<OperationItemDto> productList;
}
