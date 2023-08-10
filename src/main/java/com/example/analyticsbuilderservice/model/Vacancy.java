package com.example.analyticsbuilderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    @Id
    private String id;
    @Indexed
    private String name;
    private Area area;
    private Salary salary;
    private Type type;
    private Object responseUrl;
    // @Indexed(expireAfter = "21d")
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private Boolean archived;
    private String alternateUrl;
    private Employer employer;
    private Snippet snippet;
    private Experience experience;
    private Employment employment;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
    @Indexed
    private Set<String> queries;
}
