package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetail.Pk> {
    List<OrderDetail> findByProductProductId(int productId);
    List<OrderDetail> findByOrder_OrderID(int orderId);

}
