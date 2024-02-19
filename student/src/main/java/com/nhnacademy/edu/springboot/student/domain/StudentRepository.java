package com.nhnacademy.edu.springboot.student.domain;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
