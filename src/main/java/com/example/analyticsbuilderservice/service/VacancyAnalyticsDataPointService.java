package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDto;
import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import com.example.analyticsbuilderservice.repository.VacancyAnalyticsDataPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class VacancyAnalyticsDataPointService {

    private final VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VacancyAnalyticsDataPointService(
            VacancyAnalyticsDataPointRepository vacancyAnalyticsDataPointRepository) {
        this.vacancyAnalyticsDataPointRepository = vacancyAnalyticsDataPointRepository;
    }

    public void insertOrUpdate(VacancyAnalyticsDataPointDto dto) {
        Optional<VacancyAnalyticsDataPoint> dataPoint = vacancyAnalyticsDataPointRepository
                .findByDateAndQuery(dto.getDate(), dto.getQuery());

        if (dataPoint.isEmpty()) {
            vacancyAnalyticsDataPointRepository.save(
                    modelMapper.map(dto, VacancyAnalyticsDataPoint.class)
            );

            log.debug("Data point inserted");
        } else {
            VacancyAnalyticsDataPoint model = modelMapper.map(dto, VacancyAnalyticsDataPoint.class);
            model.setId(dataPoint.get().getId());

            vacancyAnalyticsDataPointRepository.save(model);

            log.debug("Data point updated");
        }
    }
}
