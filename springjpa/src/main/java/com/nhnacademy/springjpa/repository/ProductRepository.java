package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
