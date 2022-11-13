package warehouse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.domain.Product;
import warehouse.domain.Warehouse;
import warehouse.model.dto.ProductDto;
import warehouse.model.dto.WarehouseDto;
import warehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseDto create(String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(name);
        warehouseRepository.save(warehouse);
        return new WarehouseDto(warehouse.getId(), warehouse.getName());
    }

    public WarehouseDto findByName(String name) {
        Warehouse entity = warehouseRepository.getByName(name);
        return new WarehouseDto(entity.getId(), entity.getName());
    }

    public WarehouseDto getById(Long id) {
        Warehouse entity = warehouseRepository.getReferenceById(id);
        return new WarehouseDto(entity.getId(), entity.getName());
    }

    public List<WarehouseDto> getAll() {
        return warehouseRepository.findAll().stream()
                .map(entity ->  new WarehouseDto(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }


    public void update(WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseRepository.getReferenceById(warehouseDto.getId());
        warehouse.setName(warehouseDto.getName());
        warehouseRepository.save(warehouse);
    }
    public void delete(String name){
        warehouseRepository.deleteById(warehouseRepository.getByName(name).getId());
    }

}
