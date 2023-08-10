package com.example.analyticsbuilderservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RawAnalyticsData {
    Integer count;
    Double runningAverageSalary;
    Integer vacanciesWithSalaryCount;

    public void calculateRunningAverage(Double salary) {
        vacanciesWithSalaryCount++;
        runningAverageSalary = runningAverageSalary + (salary - runningAverageSalary) / vacanciesWithSalaryCount;
    }
}
