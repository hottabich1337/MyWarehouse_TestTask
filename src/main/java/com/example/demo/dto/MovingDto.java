package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;

import java.util.List;

public class MovingDto {
    private  Long id;
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private List<Product> productList;
}
