package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDTO;
import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import com.example.analyticsbuilderservice.repository.VacancyAnalyticsDataPointRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VacancyAnalyticsDataPointService {

    private final VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VacancyAnalyticsDataPointService(
            VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository) {
        this.vacancyAnalyticsDataPointRepository = vacancyAnalyticsDataPointRepository;
    }

    public void testCreateVacancy(VacancyAnalyticsDataPointDTO vacancyAnalyticsDataPoint) {
        vacancyAnalyticsDataPointRepository.save(
                modelMapper.map(vacancyAnalyticsDataPoint, VacancyAnalyticsDataPoint.class)
        );
    }
}
