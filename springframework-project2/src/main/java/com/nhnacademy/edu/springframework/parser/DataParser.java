package com.nhnacademy.edu.springframework.parser;

import java.util.List;

public interface DataParser {
    String parseCsv(String filePath);

    List<String[]> parseJson(String filePath);
}
