package com.nhnacademy.edu.springboot.student.repository;

import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.domain.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyStudentRepository implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return List.of(new Student("cbum", 100), new Student("arnold", 90));
    }
}
