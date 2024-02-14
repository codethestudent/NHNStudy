package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
CREATE TABLE ShoppingCart
(
    RecordID     int auto_increment,
    CartID       nvarchar(150),
    Quantity     int,
    ProductID    int,
    DateCreateed Datetime DEFAULT NOW(),

    CONSTRAINT pk_RecordID PRIMARY KEY (RecordID),
    CONSTRAINT fk_cart_ProductID FOREIGN KEY (ProductID) REFERENCES Products (ProductID)
);
 */
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

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;
}
