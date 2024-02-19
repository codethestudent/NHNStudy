package com.nhnacademy.edu.springboot.student.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() throws Exception {
        Student cbum = new Student(1L, "cbum", 100);
        studentRepository.save(cbum);

        Optional<Student> actual = studentRepository.findById(1L);
        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(cbum);
    }
}
