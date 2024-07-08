package com.junbbang.simpletelegraf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfluxDataDto {
    private long time;
    private double value;
}
