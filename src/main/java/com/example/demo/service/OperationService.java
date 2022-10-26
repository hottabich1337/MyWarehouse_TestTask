package com.example.demo.service;

import com.example.demo.dto.AdmissionDto;
import com.example.demo.dto.OperationItemDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.model.Operation;
import com.example.demo.model.OperationType;
import com.example.demo.repo.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;
    public void admission(AdmissionDto admissionDto){
        OperationItemDto operationItemDto = new OperationItemDto();


        for (int i  =0; i<admissionDto.getProductList().size();i++){
            Operation operation = new Operation();
            operation.setOperationNumber(admissionDto.getNumber());
            operation.setOperationType(OperationType.ADMISSION);
            operation.setWarehouseTo(admissionDto.getWarehouseId());
            operation.setPrice(operationItemDto.getPrice());
            operation.setCount(operationItemDto.getCount());
            operation.setProductId(operationItemDto.getArticle());
            operationRepository.save(operation);
        }
    }

}