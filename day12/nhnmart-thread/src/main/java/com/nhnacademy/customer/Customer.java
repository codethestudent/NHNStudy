package com.nhnacademy.customer;

import com.nhnacademy.mart.coupon.Coupon;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private final long id;
    private final String name;
    private int money;

    private final List<Coupon> couponList = new ArrayList<>();

    private Customer(long id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public static Customer of(long id, String name) {
        return new Customer(id, name, 10_000);
    }

    public void addCoupon(Coupon coupon) {
        couponList.add(coupon);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Coupon> getCouponList() {
        return this.couponList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
