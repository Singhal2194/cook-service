package com.cook.CookServer.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationInfo {

    @Field
    private String type = "Point";

    @Field
    private ArrayList<Double> coordinates;
}

