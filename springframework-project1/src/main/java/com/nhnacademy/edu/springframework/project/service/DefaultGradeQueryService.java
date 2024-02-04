package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultGradeQueryService implements GradeQueryService {
    private final Students csvStudents;
    private final Scores csvScores;

    @Autowired
    public DefaultGradeQueryService(Students students, Scores scores) {
        this.csvStudents = students;
        this.csvScores = scores;
    }

    @Override
    @MeasureExecutionTime
    public List<Score> getScoreByStudentName(String name) {
        return csvStudents.findAll().stream()
                .filter(student -> student.getScore() != null)
                .filter(student -> student.getName().equals(name))
                .map(Student::getScore)
                .collect(Collectors.toList());
    }

    @Override
    @MeasureExecutionTime
    public Score getScoreByStudentSeq(int seq) {
        return csvScores.findAll().stream()
                .filter(score -> score.getStudentSeq() == seq)
                .findFirst()
                .orElse(null);
    }
}
