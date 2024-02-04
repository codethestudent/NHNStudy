package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.common.TariffDataHolder;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DefaultWaterTariffService implements WaterTariffService {
    private final TariffRepository tariffRepository;
    private final TariffDataHolder tariffDataHolder;
    private List<String[]> tariff = new ArrayList<>();

    @Autowired
    public DefaultWaterTariffService(TariffRepository tariffRepository, TariffDataHolder tariffDataHolder) {
        this.tariffRepository = tariffRepository;
        this.tariffDataHolder = tariffDataHolder;
    }

    @Override
    @MeasureExecutionTime
    public void calculateCharge(int waterUsage) {
        tariff = tariffRepository.findTariffByUsage(waterUsage);
        tariff.forEach((String[] row) -> row[7] = String.valueOf(Integer.parseInt(row[6]) * waterUsage));
        tariffDataHolder.setTariff(tariff);
    }
}
