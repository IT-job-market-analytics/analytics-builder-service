package com.example.analyticsbuilderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyAnalyticsDataPointDto {
    private LocalDate date;
    private String query;
    private int vacancyCount;
    private double salary;
}
