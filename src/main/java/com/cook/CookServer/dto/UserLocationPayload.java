package com.cook.CookServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocationPayload {

    @JsonProperty("lat_lng")
    private LatLng latLng;
    @JsonProperty("user_id")
    private String userId;

}
