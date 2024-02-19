package com.nhnacademy.edu.springboot.studentmanagement.service;

import com.nhnacademy.edu.springboot.studentmanagement.entity.Student;
import com.nhnacademy.edu.springboot.studentmanagement.exception.DuplicateStudentIdException;
import com.nhnacademy.edu.springboot.studentmanagement.exception.StudentNotFoundException;
import com.nhnacademy.edu.springboot.studentmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void register(Student student) {
        if (studentRepository.existsById(student.getId())) {
            throw new DuplicateStudentIdException(student.getId());
        }
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        return student.get();
    }

    @Override
    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(Student student) {
        Optional<Student> studentOpt = studentRepository.findById(student.getId());
        if (studentOpt.isEmpty()) {
            throw new StudentNotFoundException(student.getId());
        }
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }
}
