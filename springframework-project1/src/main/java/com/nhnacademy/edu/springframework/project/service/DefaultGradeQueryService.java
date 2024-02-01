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

public class DefaultGradeQueryService implements GradeQueryService {
    private final Students csvStudents = CsvStudents.getInstance();
    private final Scores csvScores = CsvScores.getInstance();

    private List<Integer> getStudentSeqByStudentName(String name) {
        List<Integer> studentSeqList = new ArrayList<>();
        Collection<Student> studentList = csvStudents.findAll();
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                studentSeqList.add(student.getSeq());
            }
        }
        return studentSeqList;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {
        Collection<Score> scores = csvScores.findAll();
        List<Integer> studentSeqs = getStudentSeqByStudentName(name);

        List<Score> scoreList = new ArrayList<>();

        for (Integer seq : studentSeqs) {
            for (Score score : scores) {
                if (score.getStudentSeq() == seq) {
                    scoreList.add(score);
                }
            }
        }
        return scoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        Collection<Score> scores = csvScores.findAll();
        return scores.stream()
                .filter(score -> score.getScore() == seq)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
