package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.parser.DataParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DefaultTariffRepository implements TariffRepository {

    private final DataParser dataParser;
    private List<String[]> tableDatas = new ArrayList<>();

    @Autowired
    public DefaultTariffRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    @MeasureExecutionTime
    public void loadFile(String filePath) {
        String[] parts = filePath.split("\\.");

        if (parts[parts.length - 1].equals("csv")) {
            String allData = dataParser.parseCsv(filePath);
            String[] rows = allData.split("\n");
            Arrays.stream(rows).skip(1).forEach(row -> tableDatas.add(row.split(",", -1)));
        } else if (parts[parts.length - 1].equals("json")) {
            List<String[]> allData = dataParser.parseJson(filePath);
            tableDatas.addAll(allData);
        }
    }

    @Override
    @MeasureExecutionTime
    public List<String[]> findTariffByUsage(int waterUsage) {
        return tableDatas.stream()
                .filter(row ->
                        (Integer.parseInt(row[4]) <= waterUsage) && (Integer.parseInt(row[5]) >= waterUsage))
                .collect(Collectors.toList());
    }
}
