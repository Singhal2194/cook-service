package com.cook.CookServer.dto;

import lombok.Data;

@Data
public class ErrorMessagePayload {

    String error;
    String reason;

//    public ErrorMessagePayload(String reason, String error) {
//        super();
//        this.reason = reason;
//        this.error = error;
//    }

}
