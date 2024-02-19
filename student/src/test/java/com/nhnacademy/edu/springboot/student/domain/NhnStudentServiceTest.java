package com.nhnacademy.edu.springboot.student.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnStudentServiceTest {
    @Autowired
    StudentSevice studentSevice;

    @Test
    void testGetStudents() {
        List<Student> actual = studentSevice.getStudents();
        Assertions.assertThat(actual).hasSize(2);
    }
}