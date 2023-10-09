package com.nhnacademy.customer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerGenerator implements Iterator<Customer> {
    private static final CustomerGenerator INSTANCE = new CustomerGenerator();

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    public static CustomerGenerator getCustomerGenerator() {
        return INSTANCE;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Customer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Customer.of(ID_GENERATOR.incrementAndGet(), "marco" + ID_GENERATOR.get());
    }

}
