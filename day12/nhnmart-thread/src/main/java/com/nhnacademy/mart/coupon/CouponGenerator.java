package com.nhnacademy.mart.coupon;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public final class CouponGenerator implements Iterator<Coupon> {
    private static final int  COUPON_MAX_SIZE = 50;
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private static final CouponGenerator INSTANCE  = new CouponGenerator();

    public static CouponGenerator getCouponGenerator(){
        return CouponGenerator.INSTANCE;
    }

    @Override
    public synchronized boolean hasNext() {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public synchronized Coupon next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return new Coupon(ID_GENERATOR.incrementAndGet(),10000, Coupon.CouponType.DISCOUNT);
    }

}
