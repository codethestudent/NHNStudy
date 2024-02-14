package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultGradeQueryService implements GradeQueryService {
    private final Students csvStudents = CsvStudents.getInstance();
    private final Scores csvScores = CsvScores.getInstance();


    @Override
    public List<Score> getScoreByStudentName(String name) {
        return csvStudents.findAll().stream()
                .filter(student -> student.getScore() != null)
                .filter(student -> student.getName().equals(name))
                .map(Student::getScore)
                .collect(Collectors.toList());
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        return csvScores.findAll().stream()
                .filter(score -> score.getStudentSeq() == seq)
                .findFirst()
                .orElse(null);
    }
}
