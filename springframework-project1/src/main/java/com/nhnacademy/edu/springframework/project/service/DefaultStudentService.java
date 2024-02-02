package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class DefaultStudentService implements StudentService {
    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .filter(student -> !student.getScore().isFail())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .sorted(Comparator.comparing((Student student) -> student.getScore().getScore()).reversed())
                .collect(Collectors.toList());
    }

}
