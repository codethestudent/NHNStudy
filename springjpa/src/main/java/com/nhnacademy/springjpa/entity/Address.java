package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int addressId;

    @Column(name = "AddressName")
    private String addressName;

    @Column(name = "user_id")
    private String userId;
}
