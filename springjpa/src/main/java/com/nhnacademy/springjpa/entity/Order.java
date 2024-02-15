package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
CREATE TABLE Orders
(
    OrderID   int auto_increment,
    user_id   varchar(50),
    OrderDate Datetime,
    ShipDate  Datetime,

    CONSTRAINT pk_Orders PRIMARY KEY (OrderID),
    CONSTRAINT fk_Orders_CustomerID FOREIGN KEY (user_id) REFERENCES users (user_id)
);
 */
@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "OrderDate")
    private LocalDateTime orderDate;
    @Column(name = "ShipDate")
    private LocalDateTime shipDate;
}
