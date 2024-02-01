package com.nhnacademy.edu.springframework.project.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvScores implements Scores {
    private volatile static Scores csvScore;
    private List<Score> allScores;

    private CsvScores() {
    }

    /**
     * TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        if (csvScore == null) {
            synchronized (CsvScores.class) {
                if (csvScore == null) {
                    csvScore = new CsvScores();
                }
            }
        }
        return csvScore;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("data/score.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            allScores = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] splitedLine = line.split(",");
                if (splitedLine.length == 2) {
                    try {
                        Score score = new Score(
                                Integer.parseInt(splitedLine[0]),
                                Integer.parseInt(splitedLine[1])
                        );
                        allScores.add(score);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Cannot find resource file");
        }
    }

    @Override
    public List<Score> findAll() {
        load();
        return allScores;
    }
}
