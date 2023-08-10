package com.example.analyticsbuilderservice.service;

import com.example.analyticsbuilderservice.model.Vacancy;
import com.example.analyticsbuilderservice.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
    private final VacancyRepository vacancyRepository;

    public MongoService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getVacancy() {
        List<Vacancy> list = vacancyRepository.findAll();
        return list;
    }
}
