package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


import java.util.List;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements OrderRepositoryCustom {

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<User> getUserHavingOrderDetailQuantityGreaterThan(int quantity) {
        QOrder order = QOrder.order;
        QUser user = QUser.user;
        QOrderDetail orderDetail = QOrderDetail.orderDetail;

        return from(orderDetail)
                .innerJoin(orderDetail.order, order)
                .innerJoin(order.user, user)
                .where(orderDetail.quantity.gt(quantity))
                .select(user)
                .distinct()
                .fetch();
    }
}
