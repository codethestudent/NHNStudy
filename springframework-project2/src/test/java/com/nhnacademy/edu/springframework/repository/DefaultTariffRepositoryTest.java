package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.parser.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultTariffRepositoryTest {
    @Mock
    private DataParser dataParser;
    @InjectMocks
    private DefaultTariffRepository defaultTariffRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadFile() {
        String csvFileContent = "header\nvalue1,value2,value3\nvalue4,value5,value6";
        String csvFilePath = "file.csv";
        when(dataParser.parseCsv(csvFilePath)).thenReturn(csvFileContent);

        defaultTariffRepository.loadFile(csvFilePath);

        verify(dataParser).parseCsv(eq(csvFilePath));
        List<String[]> expectedData = Arrays.asList(
                new String[]{"value1", "value2", "value3"},
                new String[]{"value4", "value5", "value6"}
        );
        Assertions.assertArrayEquals(expectedData.toArray(), defaultTariffRepository.getTableDatas().toArray());
    }

    @Test
    void loadFile_withJsonFile() {
        String jsonFilePath = "file.json";
        List<String[]> jsonFileContent = Arrays.asList(
                new String[]{"json1", "data1"},
                new String[]{"json2", "data2"}
        );
        when(dataParser.parseJson(jsonFilePath)).thenReturn(jsonFileContent);

        defaultTariffRepository.loadFile(jsonFilePath);

        verify(dataParser).parseJson(eq(jsonFilePath));
        List<String[]> expectedData = Arrays.asList(
                new String[]{"json1", "data1"},
                new String[]{"json2", "data2"}
        );
        Assertions.assertArrayEquals(expectedData.toArray(), defaultTariffRepository.getTableDatas().toArray());
    }

    @Test
    void findTariffByUsage() {
        String mockFilePath = "tariffs.csv";
        when(dataParser.parseCsv(mockFilePath)).thenReturn("header\nTariff1,ProviderA,ServiceType1,2021,0,100\nTariff2,ProviderB,ServiceType2,2021,101,200");

        defaultTariffRepository.loadFile(mockFilePath);

        int testUsage = 150;
        List<String[]> result = defaultTariffRepository.findTariffByUsage(testUsage);

        String[] expectedRow = {"Tariff2", "ProviderB", "ServiceType2", "2021", "101", "200"};

        Assertions.assertEquals(1, result.size());
        Assertions.assertArrayEquals(expectedRow, result.get(0));
    }
}
