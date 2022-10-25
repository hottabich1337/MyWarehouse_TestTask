package com.example.demo.repo;

import com.example.demo.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
    Warehouse getById(Long article);
}
