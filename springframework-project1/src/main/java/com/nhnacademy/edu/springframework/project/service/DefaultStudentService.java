package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DefaultStudentService implements StudentService {

    private final Students csvStudents;

    @Autowired
    public DefaultStudentService(Students students) {
        this.csvStudents = students;
    }

    @Override
    @MeasureExecutionTime
    public Collection<Student> getPassedStudents() {
        return csvStudents.findAll().stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .filter(student -> !student.getScore().isFail())
                .collect(Collectors.toList());
    }

    @Override
    @MeasureExecutionTime
    public Collection<Student> getStudentsOrderByScore() {
        return csvStudents.findAll().stream()
                .filter(student -> Objects.nonNull(student.getScore()))
                .sorted(Comparator.comparing((Student student) -> student.getScore().getScore()).reversed())
                .collect(Collectors.toList());
    }

}
