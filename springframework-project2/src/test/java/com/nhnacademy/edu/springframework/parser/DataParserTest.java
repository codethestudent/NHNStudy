package com.nhnacademy.edu.springframework.parser;

import com.nhnacademy.edu.springframework.parser.CsvDataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserTest {
    private CsvDataParser csvDataParser;

    @BeforeEach
    public void setUp() {
        csvDataParser = new CsvDataParser();
    }

    @Test
    public void testParseCsv() {
        String parsedData = csvDataParser.parseCsv("Tariff_20220331.csv");
        Assertions.assertEquals(" 순번 ", Arrays.stream(parsedData.split(",")).findFirst().get());
        Assertions.assertEquals(" 업종 ", Arrays.stream(parsedData.split(",")).toArray()[2]);
        Assertions.assertEquals(" 지자체명 ", Arrays.stream(parsedData.split(",")).toArray()[1]);
    }

    @Test
    public void testParseJson() {
        List<String[]> tableDatas = csvDataParser.parseJson("Tariff_20220331.json");
        Assertions.assertEquals("1", tableDatas.get(0)[0]);
        Assertions.assertEquals("동두천시", tableDatas.get(0)[1]);
        Assertions.assertEquals("가정용", tableDatas.get(0)[2]);
    }
}
