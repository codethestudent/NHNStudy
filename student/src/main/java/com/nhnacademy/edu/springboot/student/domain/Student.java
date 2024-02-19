package com.nhnacademy.edu.springboot.student.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer score;

    public Student(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student() {

    }


}
