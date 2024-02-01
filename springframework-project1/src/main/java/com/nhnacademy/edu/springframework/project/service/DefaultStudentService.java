package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Slf4j
public class DefaultStudentService implements StudentService {
    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = CsvStudents.getInstance();
        Scores scoreRepository = CsvScores.getInstance();
        studentRepository.merge(scoreRepository.findAll());

        return studentRepository.findAll().stream()
                .filter(student -> !(student.getScore().isFail()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .sorted(Comparator.comparing(student -> student.getScore().getScore()))
                .collect(Collectors.toList());
    }

}
