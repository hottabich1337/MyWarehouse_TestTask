package com.example.demo.service;

import com.example.demo.dto.WarehouseDto;
import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import com.example.demo.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse getWarehouse(Long id){
        return warehouseRepository.getById(id);
    }
    public List<Warehouse> getAll(){
        return warehouseRepository.findAll();
    }
    public Warehouse createWarehouse(WarehouseDto warehouseDto){
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseDto.getId());
        warehouse.setName(warehouseDto.getName());
        return warehouse;
    }
    public void deleteWarehouse(Long id){
        Warehouse warehouse = warehouseRepository.getById(id);
        warehouseRepository.delete(warehouse);
    }
}
