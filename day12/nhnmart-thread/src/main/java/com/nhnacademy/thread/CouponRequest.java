package com.nhnacademy.thread;

import com.nhnacademy.customer.Customer;
import com.nhnacademy.mart.coupon.CouponGenerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CouponRequest extends Request {
    private final Customer customer;

    public CouponRequest(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute(){

        if(CouponGenerator.getCouponGenerator().hasNext()) {
            customer.addCoupon(CouponGenerator.getCouponGenerator().next());
            log.info("thread-id:{}, customer-id:{} - coupon-id:{}", Thread.currentThread().getId(), customer.getId() ,customer.getCouponList().get(0).getId());
        }else{
            log.info("thread-id:{}, customer-id:{} - coupon-id:{}", Thread.currentThread().getId(), customer.getId() ,"empty");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
