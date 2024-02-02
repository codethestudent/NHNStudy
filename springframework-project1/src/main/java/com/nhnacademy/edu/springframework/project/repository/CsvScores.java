package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvScores implements Scores {
    private List<Score> allScores;

    public CsvScores() {
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
