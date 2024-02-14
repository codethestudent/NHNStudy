package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

/*
CREATE TABLE Address
(
    AddressID   int auto_increment PRIMARY KEY,
    AddressName varchar(255) NOT NULL,
    user_id     varchar(50),

    CONSTRAINT fk_Address_User FOREIGN KEY (user_id) REFERENCES users (user_id)
);
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int addressId;

    @Column(name = "AddressName")
    private String addressName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
