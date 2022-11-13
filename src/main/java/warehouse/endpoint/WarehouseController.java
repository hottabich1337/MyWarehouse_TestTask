package warehouse.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.api.ApiResponse;
import warehouse.model.dto.WarehouseDto;
import warehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ApiResponse<WarehouseDto> create(@RequestBody WarehouseDto dto) {
        WarehouseDto warehouseDto = warehouseService.create(dto.getName());
        return ApiResponse.ok(warehouseDto);
    }

    @GetMapping("/all")
    public ApiResponse<List<WarehouseDto>> getAll() {
        List<WarehouseDto> all = warehouseService.getAll();
        return ApiResponse.ok(all);
    }

    @GetMapping("/{id}")
    public ApiResponse<WarehouseDto> getById(@PathVariable Long id) {
        return ApiResponse.ok(warehouseService.getById(id));
    }

    @GetMapping
    public ApiResponse<WarehouseDto> findByName(@RequestParam String name) {
        return ApiResponse.ok(warehouseService.findByName(name));
    }

    @PostMapping("/update")
    public void update(@RequestBody WarehouseDto dto){
        warehouseService.update(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam String name){
        warehouseService.delete(name);
    }
}
