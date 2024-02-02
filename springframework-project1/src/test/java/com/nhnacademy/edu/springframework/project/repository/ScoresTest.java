package com.nhnacademy.edu.springframework.project.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ScoresTest {
    @Mock
    private Scores csvScores;

    @BeforeEach
    void setup() {
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(csvScores);
        Scores csvScores1 = mock(CsvScores.class);
        assertEquals(csvScores, csvScores1);
    }

    @Test
    void load() {
        csvScores.load();
        List<Score> scores = csvScores.findAll();
        Assertions.assertNotNull(scores, "Scores list should not be null");
        Assertions.assertFalse(scores.isEmpty(), "Scores list should not be empty");
    }

    @Test
    void findAll() {
        csvScores.load();
        List<Score> scores = csvScores.findAll();
        Assertions.assertNotNull(scores);
        Assertions.assertFalse(scores.isEmpty());
    }
}