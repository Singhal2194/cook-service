package com.cook.CookServer.controllers;


import com.cook.CookServer.dto.CookLocationPayload;
import com.cook.CookServer.dto.UserLocationPayload;
import com.cook.CookServer.model.CookDetailsEntity;
import com.cook.CookServer.service.CookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CookServiceController {

    private static final Logger logger = LoggerFactory.getLogger(CookServiceController.class);


    @Autowired
    private CookService cookService;


    @PostMapping(path = "/fetch/nearby/locations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> fetchLocations(@RequestBody UserLocationPayload userLocationPayload) {

        List<CookDetailsEntity> locationEntities = cookService.fetchLocation(userLocationPayload);
        return new ResponseEntity(locationEntities, HttpStatus.OK);
    }

    @PostMapping(path = "/add/locations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addLocation(@RequestBody CookLocationPayload cookLocationPayload) {

        cookService.addLocation(cookLocationPayload);
        return new ResponseEntity("h", HttpStatus.OK);
    }


}
