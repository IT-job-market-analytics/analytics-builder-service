package com.example.analyticsbuilderservice.repository;

import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VacancyAnalyticsDataPointRepository extends CrudRepository<VacancyAnalyticsDataPoint, Integer>{
    Optional<VacancyAnalyticsDataPoint> findByDateAndQuery(LocalDate date, String query);
}
