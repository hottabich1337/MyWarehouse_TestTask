package com.example.demo.service;

import com.example.demo.dto.AdmissionDto;
import com.example.demo.dto.MovingDto;
import com.example.demo.dto.OperationItemDto;
import com.example.demo.dto.SaleDto;
import com.example.demo.model.Operation;
import com.example.demo.model.OperationType;
import com.example.demo.model.Product;
import com.example.demo.repo.OperationRepository;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.model.OperationType.*;

@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    ProductRepository productRepository;

    public void admission(AdmissionDto admissionDto) {

        for (OperationItemDto operationItemDto : admissionDto.getProductList()) {
            Operation operation = new Operation();
            operation.setNumber(admissionDto.getNumber());
            operation.setOperationType(ADMISSION);
            operation.setWarehouseTo(admissionDto.getWarehouseId());
            operation.setPrice(operationItemDto.getPrice());
            operation.setCount(operationItemDto.getCount());
            operation.setProductId(operationItemDto.getArticle());
            operationRepository.save(operation);
        }
    }

    public void sale(SaleDto saleDto) {

        for (OperationItemDto operationItemDto : saleDto.getProductList()) {
            Operation operation = new Operation();
            operation.setNumber(saleDto.getNumber());
            operation.setOperationType(OperationType.SALE);
            operation.setWarehouseFrom(saleDto.getWarehouseId());
            operation.setPrice(operationItemDto.getPrice());
            operation.setCount(operationItemDto.getCount());
            Integer count = getProductsInWarehouse(saleDto.getWarehouseId()).get(operationItemDto.getCount());
            if (operationItemDto.getCount()>count){
                throw new ArrayIndexOutOfBoundsException();
            }
            operation.setProductId(operationItemDto.getArticle());
            operationRepository.save(operation);
        }
    }

    public void moving(MovingDto movingDto) {

        for (OperationItemDto operationItemDto : movingDto.getProductList()) {
            Operation operation = new Operation();
            operation.setNumber(movingDto.getNumber());
            operation.setOperationType(OperationType.MOVING);
            operation.setWarehouseTo(movingDto.getWarehouseId1());
            operation.setWarehouseFrom(movingDto.getWarehouseId2());
            operation.setPrice(operationItemDto.getPrice());
            operation.setCount(operationItemDto.getCount());
            operation.setProductId(operationItemDto.getArticle());
            operationRepository.save(operation);
        }
    }

    public Map<String, Integer> getProductsInWarehouse(Long warehouseId) {
        List<Product> products = productRepository.findAll();
        Map<String, Integer> productMap = new HashMap<>();
        for (Product product : products) {
            Integer count = 0;
            List<Operation> operations = operationRepository.getByProductId(product.getArticle());
            for (Operation operation : operations) {
                if (operation.getOperationType() == ADMISSION) {
                    count += operation.getCount();
                } else if (operation.getOperationType() == SALE) {
                    count -= operation.getCount();
                } else {
                    if (warehouseId.equals(operation.getWarehouseTo())) {
                        count += operation.getCount();
                    } else {
                        count -= operation.getCount();
                    }
                }
            }
            productMap.put(product.getName(),count);
        }
        return productMap;

    }
}