package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class DataLoadServiceTest {
    @Mock
    private Students csvStudents;
    @Mock
    private Scores scores;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadAndMerge() {
        DataLoadService dataLoadService = new CsvDataLoadService(scores, csvStudents);

        dataLoadService.loadAndMerge();

        verify(scores, times(1)).load();
        verify(csvStudents, times(1)).load();
        verify(scores, times(1)).findAll();
        verify(csvStudents, times(1)).merge(anyList());
    }
}