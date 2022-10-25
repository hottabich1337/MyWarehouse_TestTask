package com.example.demo.controller;

import com.example.demo.dto.WarehouseDto;
import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;


    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Long id){
        return warehouseService.getWarehouse(id);
    }

    @GetMapping("/")
    public List<Warehouse> getAllWarehouses(){
        return warehouseService.getAll();
    }

    @PostMapping("/")
    public Warehouse createWarehouse(WarehouseDto warehouseDto){
        return warehouseService.createWarehouse(warehouseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Long id){
        warehouseService.deleteWarehouse(id);
    }
}
