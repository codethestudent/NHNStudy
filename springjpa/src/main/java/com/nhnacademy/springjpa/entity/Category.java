package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

/*
CREATE TABLE Categories
(
    CategoryID   INT auto_increment,
    CategoryName varchar(50),

    CONSTRAINT pk_Categories PRIMARY KEY (CategoryID)
);
 */
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "CategoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name = "CategoryName")
    private String categoryName;
}
