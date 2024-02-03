package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    private Students csvStudents;
    private Scores csvScores;

    @BeforeEach
    void setup() {
        csvStudents = new CsvStudents();
        csvScores = new CsvScores();
    }

    @Test
    void load() {
        Assertions.assertNull(csvStudents.findAll());
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

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("D");

        AtomicInteger i = new AtomicInteger();
        csvStudents.findAll().stream()
                .forEach(student -> {
                    assertEquals(list.get(i.getAndIncrement()), student.getName());
                });
    }

    @Test
    void merge() {
        csvStudents.load();
        csvScores.load();
        csvStudents.findAll().forEach(student -> assertNull(student.getScore()));

        csvStudents.merge(csvScores.findAll());

        Collection<Student> students = csvStudents.findAll();
        Assertions.assertEquals((int) students.stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .count(), csvScores.findAll().size()
        );
    }
}