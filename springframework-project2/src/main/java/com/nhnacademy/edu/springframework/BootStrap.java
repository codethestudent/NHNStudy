package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.config.JavaConfig;
import com.nhnacademy.edu.springframework.report.ResultReport;
import com.nhnacademy.edu.springframework.repository.DefaultTariffRepository;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import com.nhnacademy.edu.springframework.service.WaterTariffService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BootStrap {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
            System.out.print("enter water usage: ");
            int waterUsage = Integer.parseInt(reader.readLine());

            TariffRepository tariffRepository = context.getBean("defaultTariffRepository", TariffRepository.class);
            WaterTariffService waterTariffService = context.getBean("defaultWaterTariffService", WaterTariffService.class);

            tariffRepository.loadFile("Tariff_20220331.csv");
            waterTariffService.calculateCharge(waterUsage);

            ResultReport resultReport = context.getBean("defaultResultReport", ResultReport.class);
            resultReport.printTariffByDesc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}