package com.example.analyticsbuilderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    private int from;
    private int to;
    private String currency;
    private boolean gross;

}
