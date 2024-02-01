package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    private Students csvStudents;
    private Scores csvScores;

    @BeforeEach
    void setup() {
        csvStudents = CsvStudents.getInstance();
        csvScores = CsvScores.getInstance();
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(csvStudents);
        Students csvStudents1 = CsvStudents.getInstance();
        assertEquals(csvStudents, csvStudents1);
    }

    @Test
    void load() {
        csvStudents.load();
        Collection<Student> students = csvStudents.findAll();
        Assertions.assertNotNull(students);
        Assertions.assertFalse(students.isEmpty());
    }

    @Test
    void findAll() {
        csvStudents.load();
        Collection<Student> students = csvStudents.findAll();
        Assertions.assertNotNull(students);
        Assertions.assertFalse(students.isEmpty());
    }

    @Test
    void merge() {
        csvStudents.load();
        csvScores.load();
        csvStudents.merge(csvScores.findAll());

        Collection<Student> students = csvStudents.findAll();
        Assertions.assertEquals((int) students.stream()
                .filter(student ->
                        Objects.nonNull(student.getScore()))
                .count(), csvScores.findAll().size()
        );
    }
}