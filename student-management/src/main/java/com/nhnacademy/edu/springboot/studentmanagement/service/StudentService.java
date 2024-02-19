package com.nhnacademy.edu.springboot.studentmanagement.service;

import com.nhnacademy.edu.springboot.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    void register(Student student);

    Student getStudent(String id);

    void delete(String id);

    void update(Student student);

    List<Student> getStudentList();
}
