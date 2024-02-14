package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecordID")
    private int recordId;

    @Column(name = "CartId")
    private String cartId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "DateCreateed")
    private LocalDateTime createdAt;

    @Column(name = "ProductID")
    private int productId;
}
