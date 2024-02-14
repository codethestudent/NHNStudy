package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByModelNumber(String modelNumber);

    List<Product> findByModelNameContaining(String modelName);

    List<Product> findByCategoryCategoryId(int categoryId);
}
