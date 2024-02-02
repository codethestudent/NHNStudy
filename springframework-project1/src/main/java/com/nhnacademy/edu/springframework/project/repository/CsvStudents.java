package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CsvStudents implements Students {
    private Collection<Student> studentsCollection;

    public CsvStudents() {
    }

    @Override
    public void load() {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("data/student.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            studentsCollection = new ArrayList<>();

            studentsCollection = reader.lines()
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length == 2)
                    .map(parts -> {
                        try {
                            int id = Integer.parseInt(parts[0]);
                            String name = parts[1];
                            return new Student(id, name);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Student> findAll() {
        return studentsCollection;
    }

    @Override
    public void merge(Collection<Score> scores) {
        for (Student student : studentsCollection) {
            for (Score score : scores) {
                if (student.getSeq() == score.getStudentSeq()) {
                    student.setScore(score);
                }
            }
        }
    }
}
