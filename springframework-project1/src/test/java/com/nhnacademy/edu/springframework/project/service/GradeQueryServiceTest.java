package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class GradeQueryServiceTest {
    private GradeQueryService gradeQueryService;
    @Mock
    private Students students;
    @Mock
    private Scores scores;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        gradeQueryService = new DefaultGradeQueryService(students, scores);
    }

    @Test
    void getScoreByStudentName() {
        String studentName = "A";
        Student student1 = new Student(1, studentName);
        student1.setScore(new Score(1, 100));

        Student student2 = new Student(2, studentName);
        student2.setScore(new Score(2, 90));

        List<Student> mockStudents = Arrays.asList(student1, student2);
        when(students.findAll()).thenReturn(mockStudents);

        List<Score> scores = gradeQueryService.getScoreByStudentName(studentName);
        verify(students, times(1)).findAll();
        Assertions.assertEquals(2, scores.size());
        Assertions.assertEquals(100, scores.get(0).getScore());
    }

    @Test
    void getScoreByStudentSeq() {
        int studentSeq = 1;
        List<Score> mockScores = Collections.singletonList(new Score(studentSeq, 100));
        when(scores.findAll()).thenReturn(mockScores);

        Score score = gradeQueryService.getScoreByStudentSeq(studentSeq);

        verify(scores, times(1)).findAll();
        Assertions.assertNotNull(score);
        Assertions.assertEquals(100, score.getScore());
    }
}