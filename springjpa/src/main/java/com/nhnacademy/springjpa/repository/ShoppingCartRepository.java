package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
