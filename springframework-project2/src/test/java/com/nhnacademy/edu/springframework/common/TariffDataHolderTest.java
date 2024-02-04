package com.nhnacademy.edu.springframework.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TariffDataHolderTest {
    private TariffDataHolder tariffDataHolder;

    @BeforeEach
    void setup() {
        tariffDataHolder = new TariffDataHolder();
    }

    @Test
    void testGetTariffInitiallyNull() {
        Assertions.assertEquals(null, tariffDataHolder.getTariff());
    }

    @Test
    void testSetAndGetTariff() {
        List<String[]> expectedTariff = Arrays.asList(new String[]{"Tariff1", "ProviderA"}, new String[]{"Tariff2", "ProviderB"});
        tariffDataHolder.setTariff(expectedTariff);
        List<String[]> actualTariff = tariffDataHolder.getTariff();
        Assertions.assertEquals(expectedTariff, actualTariff, "The set tariff should be equal to the got tariff.");
    }
}
