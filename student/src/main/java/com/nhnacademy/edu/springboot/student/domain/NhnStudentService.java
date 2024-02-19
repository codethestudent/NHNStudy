package com.nhnacademy.edu.springboot.student.domain;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }
        throw new EntityNotFoundException("");
    }

    @Override
    public Student createStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            throw new IllegalStateException("id : " + student.getId() + "is already exist.");
        }
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
