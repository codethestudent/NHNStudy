package com.nhnacademy.edu.springframework.report;

import com.nhnacademy.edu.springframework.common.TariffDataHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class DefaultResultReportTest {

    @Mock
    private TariffDataHolder tariffDataHolder;

    @InjectMocks
    private DefaultResultReport defaultResultReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void printTariffByDescTest() {
        List<String[]> mockTariffData = Arrays.asList(
                new String[]{"1", "CityA", "SectorA", "", "", "", "5", "200"},
                new String[]{"2", "CityB", "SectorB", "", "", "", "4", "300"},
                new String[]{"3", "CityC", "SectorC", "", "", "", "3", "100"}
        );

        when(tariffDataHolder.getTariff()).thenReturn(mockTariffData);

        defaultResultReport.printTariffByDesc();

        verify(tariffDataHolder, times(2)).getTariff();
    }
}
