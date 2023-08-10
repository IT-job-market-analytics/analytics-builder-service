package com.example.analyticsbuilderservice.model;

import com.example.analyticsbuilderservice.dto.hh.LogoUrlsDto;
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
public class Employer {

    private String id;
    private String name;
    private String url;
    private String alternateUrl;
    private LogoUrlsDto logoUrls;
    private String vacanciesUrl;
    private Boolean accreditedItEmployer;
    private Boolean trusted;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

}
