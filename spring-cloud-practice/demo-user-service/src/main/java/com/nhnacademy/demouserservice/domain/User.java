package com.nhnacademy.demouserservice.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    private String id;
    private String pw;
    private String name;
    private LocalDateTime joinDate;

    public User(String id, String pw, String name) {
        this.id =id;
        this.pw =pw;
        this.name =name;
        joinDate =LocalDateTime.now();
    }

    public static User createUser(String userId, String userPw, String userName) {
        return new User(userId, userPw, userName);
    }
}
