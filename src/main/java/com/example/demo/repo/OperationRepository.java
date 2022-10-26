package com.example.demo.repo;

import com.example.demo.model.Operation;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    List<Operation> getByNumber(Long number);
    List<Operation> getByWarehouseFromEqualsOrWarehouseToEquals(Long id);
    List<Operation> getByProductId(Long id);
}
