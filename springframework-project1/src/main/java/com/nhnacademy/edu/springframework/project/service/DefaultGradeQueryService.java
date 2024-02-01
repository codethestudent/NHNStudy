package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultGradeQueryService implements GradeQueryService {
    private final Students csvStudents = CsvStudents.getInstance();
    private final Scores csvScores = CsvScores.getInstance();

    private List<Integer> getStudentSeqByStudentName(String name) {
        List<Integer> studentSeqList = new ArrayList<>();
        Collection<Student> studentList = csvStudents.findAll();
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                studentSeqList.add(student.getSeq());
            }
        }
        return studentSeqList;
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        // resources/data/student.csv 를 보면 학번, 이름으로 구성되어있습니다. 학번은 숫자, 이름은 알파벳입니다.
        // resources/data/score.csv 를 보면 학번, 점수로 구성되어있습니다. 학번은 숫자, 점수는 숫자입니다.
        //
        // 만약 getScoreByStudentName() 인자 name에 동명이인인 학생이름을 넣으면, 동명이인의 Score 들을 리턴합니다.
        // 인자 - 학생이름
        // 반환 - 점수리스트
        //
        // Hint. CsvStudents 클래스의 findAll() 이 있네요? 적절히 필터링하고 찾아오면 되겠죠?
        //
        Collection<Score> scores = csvScores.findAll();
        List<Integer> studentSeqs = getStudentSeqByStudentName(name);

        List<Score> scoreList = new ArrayList<>();

        for (Integer seq : studentSeqs) {
            for (Score score : scores) {
                if (score.getStudentSeq() == seq) {
                    scoreList.add(score);
                }
            }
        }
        return scoreList;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학번으로 점수를 반환합니다. seq 인자가 학번입니다.
        Collection<Score> scores = csvScores.findAll();
        for (Score score : scores) {
            if (score.getStudentSeq() == seq) {
                return score;
            }
        }
        throw new RuntimeException();
    }
}
