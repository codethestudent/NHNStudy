package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "CategoryID")
    private int categoryId;
    @Column(name = "CategoryName")
    private String categoryName;
}
