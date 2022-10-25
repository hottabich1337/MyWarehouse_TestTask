package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;

import java.util.List;

public class AdmissionDto {
    private Long id;
    private Warehouse admissionWarehouse;
    private List<Product> productList;
}
