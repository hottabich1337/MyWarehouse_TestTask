package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;

import java.util.List;

public class SaleDto {
    private  Long id;
    private Warehouse saleWarehouse;
    private List<Product> productList;
}
