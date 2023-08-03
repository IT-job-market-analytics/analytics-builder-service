package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDTO;
import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import com.example.analyticsbuilderservice.repository.VacancyAnalyticsDataPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyAnalyticsDataPointService {

    private VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository;

    @Autowired
    public VacancyAnalyticsDataPointService(VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository) {
        this.vacancyAnalyticsDataPointRepository = vacancyAnalyticsDataPointRepository;
    }

    public void testCreateVacancy(VacancyAnalyticsDataPointDTO vacancyAnalyticsDataPoint) {
        System.err.println("передал = " + vacancyAnalyticsDataPoint);
        vacancyAnalyticsDataPointRepository.save(vacancyAnalyticsDataPoint);
    }
}
