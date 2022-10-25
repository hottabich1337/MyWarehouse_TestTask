package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productServise;


    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productServise.getAllProducts();
    }

    @GetMapping("/{article}")
    public Product getProductByArticle(@PathVariable Long article){
        return productServise.getProduct(article);
    }

    @PostMapping ("/")
    public Product createProduct(@RequestBody ProductDto productDto){
        return productServise.createProduct(productDto);
    }

    @DeleteMapping ("/{article}")
    public void deleteProduct(@PathVariable Long article){
        productServise.deleteProduct(article);
    }

}
