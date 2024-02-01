package com.nhnacademy.edu.springframework.project.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    private Scores csvScores;

    @BeforeEach
    void setup() {
        csvScores = CsvScores.getInstance();
    }

    @Test
    void getInstance() {
        Assertions.assertNotNull(csvScores);
        Scores csvScores1 = CsvScores.getInstance();
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