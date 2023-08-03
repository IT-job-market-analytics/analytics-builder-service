package com.example.analyticsbuilderservice.controller;

import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDTO;
import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import com.example.analyticsbuilderservice.service.VacancyAnalyticsDataPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacancy")
@Slf4j
public class VacancyAnalyticsDataPointController {
    private final VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService;

    @Autowired
    public VacancyAnalyticsDataPointController(VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService) {
        this.vacancyAnalyticsDataPointService = vacancyAnalyticsDataPointService;
    }

    @PostMapping
    public void createVacancy(@RequestBody VacancyAnalyticsDataPointDTO vacancyAnalyticsDataPointDTO) {
        log.warn("work controller:createVacancy");
        log.warn("пришло " + vacancyAnalyticsDataPointDTO);
        vacancyAnalyticsDataPointService.testCreateVacancy(vacancyAnalyticsDataPointDTO);
        log.info("success???");
    }
}
