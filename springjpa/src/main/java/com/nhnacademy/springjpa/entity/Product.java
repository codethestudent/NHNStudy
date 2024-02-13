package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "CategoryID")
    private int categoryId;
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
