package com.cook.CookServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LatLng {

    public LatLng(Double lat, Double lng, Long timestamp) {
        super();
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
    }

    public LatLng(Double lat, Double lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }

    public LatLng() {
    }

    public Double lat;
    public Double lng;
    public Long timestamp;
}


