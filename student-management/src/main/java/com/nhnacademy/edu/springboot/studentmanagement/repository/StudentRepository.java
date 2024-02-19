package com.nhnacademy.edu.springboot.studentmanagement.repository;

import com.nhnacademy.edu.springboot.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
