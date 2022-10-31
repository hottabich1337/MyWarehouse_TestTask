package warehouse.service.report;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.Warehouse;
import warehouse.model.dto.ProductDto;
import warehouse.model.dto.WarehouseDto;
import warehouse.model.report.ReportFormat;
import warehouse.model.report.ReportType;
import warehouse.repository.WarehouseRepository;
import warehouse.service.OperationService;
import warehouse.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JsonReportBuilder implements ReportBuilder {

    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private OperationService operationService;

    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.JSON;
    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        if (type == ReportType.FULL_PRODUCT_VIEW) {
            return buildFullProductReport(filteredItems);
        } else {
            return buildLefoversReport();
        }
    }

    private File buildLefoversReport() {
        List<Warehouse> allWarehouses = warehouseRepository.findAll();
        List<WarehouseDto> allWarehouseDto = new ArrayList<>();
        for (int i=0;i<allWarehouses.size();i++){

            WarehouseDto dto = new WarehouseDto();
            Warehouse warehouse = allWarehouses.get(i);
            dto.setName(warehouse.getName());

            Map<String, Integer> productMap = operationService.getProductsInWarehouse(allWarehouses.get(i).getId());
            dto.setMaps(productMap);
            allWarehouseDto.add(dto);
        }
        String resultFileName = "./reports/build_leftovers_report" + LocalDate.now().toString();
        File file = new File(resultFileName);
        try {
            objectMapper.writeValue(file, allWarehouseDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private File buildFullProductReport(List<String> filtered) {
        List<ProductDto> allProducts;
        if (filtered.isEmpty()) {
            allProducts = productService.viewAllProduct().stream()
                    .map(entity -> mapper.map(entity, ProductDto.class))
                    .collect(Collectors.toList());
        } else {
            allProducts = productService.getProductsByNames(filtered).stream()
                    .map(entity -> mapper.map(entity, ProductDto.class))
                    .collect(Collectors.toList());;
        }
        String resultFileName = "./reports/full_product_review_" + LocalDate.now().toString();
        File file = new File(resultFileName);
        try {
            objectMapper.writeValue(file, allProducts);
        } catch (IOException e) {
            throw new RuntimeException("Can not save report to file: " + resultFileName);
        }
        return file;
    }
}
