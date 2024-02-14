package com.nhnacademy.edu.springframework.repository;

import java.util.List;

public interface TariffRepository {
    void loadFile(String filePath);

    List<String[]> findTariffByUsage(int waterUsage);
}
