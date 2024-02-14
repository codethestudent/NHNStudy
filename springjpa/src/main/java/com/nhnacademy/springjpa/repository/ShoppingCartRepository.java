package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Optional<ShoppingCart> findByCartId(String cartId);

    List<ShoppingCart> getShoppingCartsByCartId(String cartId);

    void deleteShoppingCartByCartId(String cartId);
}
