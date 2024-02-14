package com.nhnacademy.mart.employee;

public class Employee {

    private final long id;
    private final String name;

    private Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Employee of(long id, String name){
        return new Employee(id,name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
