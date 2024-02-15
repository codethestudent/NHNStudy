package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.entity.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface OrderRepositoryCustom {
    List<User> getUserHavingOrderDetailQuantityGreaterThan(int quantity);
}
