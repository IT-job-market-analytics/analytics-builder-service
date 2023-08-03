package com.example.analyticsbuilderservice.repository;

import com.example.analyticsbuilderservice.model.VacancyAnalyticsDataPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyAnalyticsDataPointRepository extends CrudRepository<VacancyAnalyticsDataPoint, Integer>{
}
