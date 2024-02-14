package com.nhnacademy.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @Column(name = "OrderID")
    private int orderId;

    @Id
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "UnitCost")
    private double unitCost;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        private int orderId;
        private int productId;
    }
}
