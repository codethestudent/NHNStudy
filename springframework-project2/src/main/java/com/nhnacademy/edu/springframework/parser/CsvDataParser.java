package com.nhnacademy.edu.springframework.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CsvDataParser implements DataParser {

    @Override
    @MeasureExecutionTime
    public String parseCsv(String filePath) {
        String allData = "";
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                allData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allData;
    }

    @Override
    @MeasureExecutionTime
    public List<String[]> parseJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<String[]> tableDatas = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filePath)) {
            List<Map<String, Object>> jsonData = mapper.readValue(is, new TypeReference<>() {
            });
            jsonData.forEach(jsonMap -> {
                String[] row = jsonMap.values().stream()
                        .map(Object::toString)
                        .toArray(String[]::new);
                tableDatas.add(row);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableDatas;
    }
}
