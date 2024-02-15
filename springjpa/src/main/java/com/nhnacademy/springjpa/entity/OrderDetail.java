package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/*
CREATE TABLE OrderDetails
(
    OrderID   int,
    ProductID int,
    Quantity  int,
    UnitCost  decimal(15),
    AddressID int,

    CONSTRAINT pk_OrderDetails PRIMARY KEY (OrderID, ProductID),
    CONSTRAINT fk_OrderDetails_Orders FOREIGN KEY (OrderID) REFERENCES Orders (OrderID),
    CONSTRAINT fk_OrderDetails_Products FOREIGN KEY (ProductID) REFERENCES Products (ProductID),
    CONSTRAINT fk_OrderDetails_Address FOREIGN KEY (AddressID) REFERENCES Address (AddressID)
);
 */
@Entity
@Getter
@Setter
@Table(name = "OrderDetails")
public class OrderDetail {
    @EmbeddedId
    private Pk id;
    @MapsId("orderId")
    @OneToOne
    @JoinColumn(name = "OrderID")
    private Order order;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "UnitCost")
    private double unitCost;

    @OneToOne
    @JoinColumn(name = "AddressID")
    private Address address;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        private int orderId;
        private int productId;
    }
}
