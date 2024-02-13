package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    @Column(name = "ProductID")
    private int productId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Comments")
    private String comments;
}
