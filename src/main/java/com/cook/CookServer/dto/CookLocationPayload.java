package com.cook.CookServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class CookLocationPayload {

        @JsonProperty("lat_lng")
        private LatLng latLng;
        private String city;
        private String country;
        @JsonProperty("cook_id")
        private String cookId;
    }

