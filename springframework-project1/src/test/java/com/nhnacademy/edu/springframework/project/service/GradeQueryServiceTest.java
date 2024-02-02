package com.nhnacademy.edu.springframework.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    @Test
    void getScoreByStudentName() {
        GradeQueryService gradeQueryService = new DefaultGradeQueryService();
        DataLoadService dataLoadService = new CsvDataLoadService();
        dataLoadService.loadAndMerge();

        Assertions.assertEquals(30, gradeQueryService.getScoreByStudentName("A").get(0).getScore());
        Assertions.assertEquals(80, gradeQueryService.getScoreByStudentName("B").get(0).getScore());
    }

    @Test
    void getScoreByStudentSeq() {
        GradeQueryService gradeQueryService = new DefaultGradeQueryService();
        DataLoadService dataLoadService = new CsvDataLoadService();
        dataLoadService.loadAndMerge();

        Assertions.assertEquals(30, gradeQueryService.getScoreByStudentSeq(1).getScore());
        Assertions.assertEquals(80, gradeQueryService.getScoreByStudentSeq(2).getScore());
        Assertions.assertEquals(70, gradeQueryService.getScoreByStudentSeq(3).getScore());
    }
}