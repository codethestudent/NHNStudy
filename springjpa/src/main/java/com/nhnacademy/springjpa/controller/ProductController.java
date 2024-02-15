package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ProductNameOnly;
import com.nhnacademy.springjpa.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductNameOnly> getProducts(Pageable pageable) {
        return productRepository.getAllBy(pageable).getContent();
    }
}
