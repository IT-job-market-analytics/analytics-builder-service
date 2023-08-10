package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.dto.AnalyticsBuilderServiceTaskDto;
import com.example.analyticsbuilderservice.dto.VacancyAnalyticsDataPointDto;
import com.example.analyticsbuilderservice.model.Salary;
import com.example.analyticsbuilderservice.model.Vacancy;
import com.example.analyticsbuilderservice.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class Consumer {
    private final VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService;
    private final VacancyRepository vacancyRepository;

    public Consumer(VacancyAnalyticsDataPointService vacancyAnalyticsDataPointService, VacancyRepository vacancyRepository) {
        this.vacancyAnalyticsDataPointService = vacancyAnalyticsDataPointService;
        this.vacancyRepository = vacancyRepository;
    }

    @RabbitListener(queues = {"${rabbitmq.queue}"})
    public void consume(AnalyticsBuilderServiceTaskDto analyticsBuilderServiceTaskDto) {
        log.info("Task received");

        List<Vacancy> vacancies = vacancyRepository.findAll();
        log.info(vacancies.size() + " vacancies found");

        Map<String, RawAnalyticsData> data = new HashMap<>();
        for (Vacancy vacancy : vacancies) {
            Set<String> queries = vacancy.getQueries();

            for (String query : queries) {
                if (!data.containsKey(query)) {
                    data.put(query, new RawAnalyticsData(0, 0d, 0));
                }

                RawAnalyticsData rawAnalyticsData = data.get(query);
                rawAnalyticsData.setCount(rawAnalyticsData.getCount() + 1);

                if (vacancy.getSalary() != null) {
                    Salary salary = vacancy.getSalary();
                    String currency = salary.getCurrency();

                    if (currency.equals("RUR")) {
                        Integer from = salary.getFrom();
                        Integer to = salary.getTo();

                        if (to != null) {
                            rawAnalyticsData.calculateRunningAverage(to.doubleValue());
                        } else if (from != null) {
                            rawAnalyticsData.calculateRunningAverage(from.doubleValue());
                        }
                    }
                }
            }
        }

        log.info("Raw data calculated for " + data.size() + " queries");

        LocalDate date = LocalDate.now();
        for (Map.Entry<String, RawAnalyticsData> stringRawAnalyticsDataEntry : data.entrySet()) {
            String query = stringRawAnalyticsDataEntry.getKey();
            RawAnalyticsData rawAnalyticsData = stringRawAnalyticsDataEntry.getValue();

            VacancyAnalyticsDataPointDto dto = new VacancyAnalyticsDataPointDto();
            dto.setDate(date);
            dto.setQuery(query);
            dto.setVacancyCount(rawAnalyticsData.getCount());
            dto.setSalary(rawAnalyticsData.getRunningAverageSalary());

            vacancyAnalyticsDataPointService.insertOrUpdate(dto);
        }

        log.info("Task completed");
    }
}