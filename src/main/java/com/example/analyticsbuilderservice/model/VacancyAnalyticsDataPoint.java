package com.example.analyticsbuilderservice.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "Vacancy_analytics")
public class VacancyAnalyticsDataPoint {

    @Id
    private int id;

    @Column("date")
    private Date date;

    @Column("query")
    private String query;

    @Column("vacancy_count")
    private int vacancyCount;

    @Column("average_salary")
    private double salary;

}