package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

class StudentServiceTest {
    private DefaultStudentService studentService;
    @Mock
    private Students students;

    List<Student> mockStudents;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        studentService = new DefaultStudentService(students);

        Student student1 = new Student(1, "A");
        student1.setScore(new Score(1, 100));

        Student student2 = new Student(2, "A");
        student2.setScore(new Score(2, 90));

        Student student3 = new Student(3, "C");
        student3.setScore(new Score(3, 40));

        mockStudents = Arrays.asList(student1, student2, student3);
    }

    @Test
    void getPassedStudents() {
        when(students.findAll()).thenReturn(mockStudents);

        Collection<Student> passedStudents = studentService.getPassedStudents();

        verify(students, times(1)).findAll();
        Assertions.assertNotNull(passedStudents);
        Assertions.assertEquals(2, passedStudents.size());
    }

    @Test
    void getStudentsOrderByScore() {
        when(students.findAll()).thenReturn(mockStudents);

        List<Student> students = (List<Student>) studentService.getStudentsOrderByScore();
        Assertions.assertEquals("A",
                students.stream()
                        .findFirst()
                        .map(student -> student.getName())
                        .orElse("Default Name")
        );
        Assertions.assertEquals(3, students.size(), "Should return all students");
        Assertions.assertTrue(students.get(0).getScore().getScore() >= students.get(1).getScore().getScore(), "Students should be ordered by score in descending order");
        Assertions.assertTrue(students.get(1).getScore().getScore() >= students.get(2).getScore().getScore(), "Students should be ordered by score in descending order");
    }
}