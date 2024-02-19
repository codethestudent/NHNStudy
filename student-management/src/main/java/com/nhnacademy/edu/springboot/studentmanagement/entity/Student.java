package com.nhnacademy.edu.springboot.studentmanagement.entity;

import com.nhnacademy.edu.springboot.studentmanagement.domain.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;
}
