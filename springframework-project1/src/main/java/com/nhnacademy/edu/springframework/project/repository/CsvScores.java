package com.nhnacademy.edu.springframework.project.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvScores implements Scores {
    private volatile static Scores csvScore;
    private List<Score> allScores;

    private CsvScores() {
    }

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
        return allScores;
    }
}
