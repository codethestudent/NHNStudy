package com.nhnacademy.springjpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "OrderDate")
    private LocalDateTime orderDate;
    @Column(name = "ShipDate")
    private LocalDateTime shipDate;
}
