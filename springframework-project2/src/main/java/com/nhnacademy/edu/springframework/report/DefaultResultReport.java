package com.nhnacademy.edu.springframework.report;

import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import com.nhnacademy.edu.springframework.common.TariffDataHolder;
import com.nhnacademy.edu.springframework.repository.DefaultTariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DefaultResultReport implements ResultReport {

    private final TariffDataHolder tariffDataHolder;

    @Autowired
    public DefaultResultReport(TariffDataHolder tariffDataHolder) {
        this.tariffDataHolder = tariffDataHolder;
    }

    @Override
    @MeasureExecutionTime
    public void printTariffByDesc() {
        int i = 0;
        tariffDataHolder.getTariff().sort(Comparator.comparingInt(arr -> Integer.parseInt(arr[7])));
        for (String[] array : tariffDataHolder.getTariff()) {
            System.out.println(stringLayout(array));
            if (i++ == 5) {
                break;
            }
        }
    }

    @MeasureExecutionTime
    private String stringLayout(String[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("WaterBill{city='");
        sb.append(array[1]);
        sb.append("', sector='");
        sb.append(array[2]);
        sb.append("', unitPrice=");
        sb.append(array[6]);
        sb.append(", billTotal=");
        sb.append(array[7]);
        sb.append("}");
        return sb.toString();
    }
}
