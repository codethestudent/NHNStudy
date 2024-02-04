package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.common.TariffDataHolder;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class WaterTariffServiceTest {
    @Mock
    private TariffRepository tariffRepository;
    @Mock
    private TariffDataHolder tariffDataHolder;
    @InjectMocks
    private DefaultWaterTariffService waterTariffService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calculateCharge() {
        int waterUsage = 100;
        List<String[]> mockTariff = new ArrayList<>();
        when(tariffRepository.findTariffByUsage(waterUsage)).thenReturn(mockTariff);

        waterTariffService.calculateCharge(waterUsage);

        verify(tariffDataHolder, times(1)).setTariff(mockTariff);
    }
}
