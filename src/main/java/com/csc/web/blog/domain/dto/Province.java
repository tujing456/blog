package com.csc.web.blog.domain.dto;

import lombok.Data;

import java.util.List;



@Data
public class Province {
    private String name;
    private String level;
    private String code;
    private List<City> cities;
}