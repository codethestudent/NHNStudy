package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private int categoryId;
    @Column(name = "CategoryName")
    private String categoryName;
}
