package com.example.analyticsbuilderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private String id;
    private String name;
    private String url;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}