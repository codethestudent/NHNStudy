package com.nhnacademy.edu.springframework.common;

import com.nhnacademy.edu.springframework.annotation.MeasureExecutionTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@MeasureExecutionTime
@Component
public class TariffDataHolder {
    private List<String[]> tariff;
}
