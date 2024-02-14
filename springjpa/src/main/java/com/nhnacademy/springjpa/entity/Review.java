package com.nhnacademy.springjpa.entity;

import javax.persistence.*;
/*
CREATE TABLE Reviews
(
    ReviewID  int auto_increment,
    ProductID int,
    user_id   varchar(50),
    Rating    int,
    Comments  text,

    CONSTRAINT pk_ReviewID PRIMARY KEY (ReviewID),
    CONSTRAINT fk_Review_Products FOREIGN KEY (ProductID) REFERENCES Products (ProductID),
    CONSTRAINT fk_Review_Customer FOREIGN KEY (user_id) REFERENCES users (user_id)
);
 */
@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Comments")
    private String comments;
}
