package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import lombok.extern.slf4j.Slf4j;

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
public class CsvStudents implements Students {
    private volatile static Students students;
    private Collection<Student> studentsCollection;

    private CsvStudents() {
    }

    /**
     * TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Students getInstance() {
        if (students == null) {
            synchronized (CsvStudents.class) {
                if (students == null) {
                    students = new CsvStudents();
                }
            }
        }
        return students;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
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

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     *
     * @param scores
     */
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
