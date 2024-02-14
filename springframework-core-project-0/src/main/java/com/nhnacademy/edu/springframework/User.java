package com.nhnacademy.edu.springframework;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
