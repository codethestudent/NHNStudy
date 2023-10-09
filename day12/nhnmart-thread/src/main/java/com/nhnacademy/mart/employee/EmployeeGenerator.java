package com.nhnacademy.mart.employee;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public final class EmployeeGenerator implements Iterator<Employee> {

    private static final EmployeeGenerator INSTANCE = new EmployeeGenerator();
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    public static EmployeeGenerator getEmployeeGenerator(){
        return EmployeeGenerator.INSTANCE;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Employee next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return Employee.of(ID_GENERATOR.incrementAndGet(),"직원" + ID_GENERATOR.get());
    }

}
