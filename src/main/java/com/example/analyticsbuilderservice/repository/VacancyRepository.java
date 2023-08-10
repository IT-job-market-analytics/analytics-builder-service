package com.example.analyticsbuilderservice.repository;

import com.example.analyticsbuilderservice.model.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends MongoRepository<Vacancy, String> {
    List<Vacancy> findByQueriesContains(String query);
}
