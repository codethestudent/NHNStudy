package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DataLoadServiceTest {
    private final Students csvStudents = CsvStudents.getInstance();

    @Test
    void loadAndMerge() {
        csvStudents.load();
        DataLoadService dataLoadService = new CsvDataLoadService();

        dataLoadService.loadAndMerge();

        Assertions.assertEquals((int) csvStudents.findAll().stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .count(), csvStudents.findAll().size() - 1
        );
    }
}