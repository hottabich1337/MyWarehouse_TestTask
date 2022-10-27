package com.example.demo.controller;

import com.example.demo.dto.AdmissionDto;
import com.example.demo.dto.MovingDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping("/admission")
    public void admission(@RequestBody AdmissionDto admissionDto){
        operationService.admission(admissionDto);
    }
    @PostMapping("/sale")
    public void sale(@RequestBody SaleDto saleDto){
        operationService.sale(saleDto);
    }
    @PostMapping("/moving")
    public void moving(@RequestBody MovingDto movingDto){
        operationService.moving(movingDto);
    }


    @PostMapping("/gpw")
    public Map<String,Integer> getProductsInWarehouse(@RequestBody Long warehouseId){
        return operationService.getProductsInWarehouse(warehouseId);
    }

}
