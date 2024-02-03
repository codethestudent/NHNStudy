package com.nhnacademy.edu.springframework.project.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {
    private Scores csvScores;

    @BeforeEach
    void setup() {
        csvScores = new CsvScores();
    }

    @Test
    void load() {
        assertNull(csvScores.findAll());
        csvScores.load();
        assertFalse(csvScores.findAll().isEmpty());
    }

    @Test
    void findAll() {
        csvScores.load();
        List<Score> scores = csvScores.findAll();
        Assertions.assertNotNull(scores);
        Assertions.assertFalse(scores.isEmpty());
        List<String> list = new ArrayList<>();
        list.add("30");
        list.add("80");
        list.add("70");

        AtomicInteger i = new AtomicInteger();
        csvScores.findAll().stream()
                .forEach(score -> {
                    assertEquals(Integer.parseInt(list.get(i.getAndIncrement())), score.getScore());
                });
    }
}