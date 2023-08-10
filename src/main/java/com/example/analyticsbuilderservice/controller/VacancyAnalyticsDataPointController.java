package com.example.analyticsbuilderservice.controller;

import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDTO;
import com.example.analyticsbuilderservice.service.MongoService;
import com.example.analyticsbuilderservice.service.VacancyAnalyticsDataPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacancy")
@Slf4j
public class VacancyAnalyticsDataPointController {
    private final VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService;
    private final MongoService mongoService;

    @Autowired
    public VacancyAnalyticsDataPointController(VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService, MongoService mongoService) {
        this.vacancyAnalyticsDataPointService = vacancyAnalyticsDataPointService;
        this.mongoService = mongoService;
    }

    @PostMapping
    public void createVacancy(@RequestBody VacancyAnalyticsDataPointDTO vacancyAnalyticsDataPointDTO) {
        log.warn("work controller:createVacancy");
        log.warn("vacancyAnalyticsDataPointDTO = " + vacancyAnalyticsDataPointDTO);
        vacancyAnalyticsDataPointService.testCreateVacancy(vacancyAnalyticsDataPointDTO);
    }

    @GetMapping
    public void getVacancy() {
        mongoService.getVacancy();
    }
}
