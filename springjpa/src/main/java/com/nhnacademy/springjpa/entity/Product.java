package com.nhnacademy.springjpa.entity;

import javax.persistence.*;
/*
CREATE TABLE Products
(
    ProductID    INT auto_increment,
    CategoryID   INT,
    ModelNumber  nvarchar(10),
    ModelName    nvarchar(120),
    ProductImage nvarchar(30),
    UnitCost     decimal(15),
    Description  text,

    CONSTRAINT pk_Products PRIMARY KEY (ProductID),
    CONSTRAINT fk_Products_Categories FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID)
);
 */
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;
    @Column(name = "ModelNumber")
    private String modelNumber;
    @Column(name = "ModelName")
    private String modelName;
    @Column(name = "ProductImage")
    private String productImage;
    @Column(name = "UnitCost")
    private double unitCost;
    @Column(name = "Description")
    private String description;
}
