package warehouse.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import warehouse.domain.Product;
import warehouse.model.api.ApiResponse;
import warehouse.model.dto.ProductDto;
import warehouse.service.ProductService;
import warehouse.service.WarehouseService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    /////////////////////////////////////////
    @Autowired
    private WarehouseService warehouseService;
    /////////////////////////////////////////

    @PostMapping("/")
    public ApiResponse<ProductDto> create(@Valid @RequestBody ProductDto dto) {
        ProductDto product = productService.createProduct(dto);
        return ApiResponse.ok(product);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/update")
    public void update(@Valid @RequestBody ProductDto dto) {
         productService.update(dto);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/")
    public ApiResponse<List<Product>> getAll() {
        return ApiResponse.ok(productService.viewAllProduct());
    }

    @GetMapping("/{article}")
    public ApiResponse<Product> getByArticle(@PathVariable Long article){
        return ApiResponse.ok(productService.searchByArticle(article));
    }
    @PostMapping("/delete")
    public void delete(@RequestBody ProductDto dto) {
        productService.delete(dto.getId());
    }

//Прочитать, изменить и сохранить в базу
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
