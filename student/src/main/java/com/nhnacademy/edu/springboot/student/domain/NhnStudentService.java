package com.nhnacademy.edu.springboot.student.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhnStudentService implements StudentSevice {
    private final StudentRepository studentRepository;

    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
