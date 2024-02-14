package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserUserId(String userId);

    List<Order> findByOrderDate(LocalDateTime orderDate);
}
