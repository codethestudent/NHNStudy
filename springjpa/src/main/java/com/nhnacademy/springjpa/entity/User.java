package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {
    public enum Auth {
        ROLE_ADMIN, ROLE_USER
    }

    @Id
    @Column(name = "UserID")
    private String userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserPassword")
    private String userPassword;

    @Column(name = "UserBirth")
    private String userBirth;

    @Column(name = "UserAuth")
    private Auth userAuth;

    @Column(name = "UserPoint")
    private int userPoint;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "LatestLoginAt")
    private LocalDateTime latestLoginAt;
}
