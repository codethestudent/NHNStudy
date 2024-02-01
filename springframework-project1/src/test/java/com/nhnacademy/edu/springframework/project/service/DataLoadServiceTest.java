package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {
    private final Students csvStudents = CsvStudents.getInstance();

    @Test
    void loadAndMerge() {
        csvStudents.load();
    }
}