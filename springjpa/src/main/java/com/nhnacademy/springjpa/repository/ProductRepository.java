package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductNameOnly;
import com.nhnacademy.springjpa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByModelNumber(String modelNumber);

    List<Product> findByModelNameContaining(String modelName);

    @Query("select p from Product p where p.category.categoryId = ?1")
    List<Product> findByCategoryId(int categoryId);

    Page<ProductNameOnly> getAllBy(Pageable pageable);
}
