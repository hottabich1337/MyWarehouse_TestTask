package warehouse.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.domain.Operation;
import warehouse.model.api.ApiResponse;
import warehouse.model.dto.AdmissionDto;
import warehouse.model.dto.MovingDto;
import warehouse.model.dto.SaleDto;
import warehouse.service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("/admission")
    public ApiResponse admission(@RequestBody AdmissionDto admissionDto) {
        operationService.admission(admissionDto);
        return ApiResponse.ok();
    }

    @PostMapping("/sale")
    public ApiResponse sale(@RequestBody SaleDto saleDto) {
        operationService.sale(saleDto);
        return ApiResponse.ok();
    }

    @PostMapping("/moving")
    public ApiResponse moving(@RequestBody MovingDto movingDto) {
        operationService.moving(movingDto);
        return ApiResponse.ok();
    }

    @GetMapping
    public ApiResponse<List<Operation>> getAllOperations(){
        return ApiResponse.ok(operationService.getAllOperations());
    }

    @PostMapping("/delete")
    public ApiResponse delete(@RequestParam Long id){
        operationService.delete(id);
        return ApiResponse.ok();
    }

}
