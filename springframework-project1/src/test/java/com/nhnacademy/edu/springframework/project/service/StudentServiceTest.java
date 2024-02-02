package com.nhnacademy.edu.springframework.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private final DataLoadService dataLoadService = new CsvDataLoadService();
    private final DefaultStudentService studentService = new DefaultStudentService();

    @BeforeEach
    void setup() {
        dataLoadService.loadAndMerge();
    }

    @Test
    void getPassedStudents() {
        Collection<Student> passedStudents = studentService.getPassedStudents();

        Assertions.assertNotNull(passedStudents);
        Assertions.assertEquals(2, passedStudents.size());
    }

    @Test
    void getStudentsOrderByScore() {
        Collection<Student> students = studentService.getStudentsOrderByScore();
        Assertions.assertEquals("B",
                students.stream()
                        .findFirst()
                        .map(student -> student.getName())
                        .orElse("Default Name")
        );
    }
}