package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDto productDto){
        Product product = new Product();
        product.setArticle(productDto.getArticle());
        product.setName(productDto.getName());
        productRepository.save(product);
        return product;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(Long arcticle){
        return productRepository.getByArticle(arcticle);
    }
    public void deleteProduct(Long article){
        Product product =  productRepository.getByArticle(article);
        productRepository.delete(product);
    }

}
