package com.cook.CookServer.service;

import com.cook.CookServer.dto.CookLocationPayload;
import com.cook.CookServer.dto.LocationInfo;
import com.cook.CookServer.dto.UserLocationPayload;
import com.cook.CookServer.model.CookDetailsEntity;
import com.cook.CookServer.repository.CookDetailsRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CookService {


    private static final Logger logger = LoggerFactory.getLogger(CookService.class);
    @Autowired
    private CookDetailsRepository cookDetailsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CookDetailsEntity> fetchLocation(UserLocationPayload userLocationPayload) {

        validatePayload(userLocationPayload);
        List<CookDetailsEntity> locationEntities = findNearestPoints(userLocationPayload);

        return locationEntities;
    }

    private List<CookDetailsEntity> findNearestPoints(UserLocationPayload userLocationPayload) {

        Point currentLoc = new Point(new Position(userLocationPayload.getLatLng().lng, userLocationPayload.getLatLng().lat));
        List<CookDetailsEntity> locationEntities = new ArrayList<>();

        try {
            FindIterable<Document> results = mongoTemplate.getCollection("cook_locations").find(
                    Filters.near("locationInfo", currentLoc, 1000.0, 0.0));
            for (Document doc : results) {
                CookDetailsEntity locationEntity = mongoTemplate.getConverter().read(CookDetailsEntity.class, doc);
                locationEntities.add(locationEntity);
            }
        } catch (Exception e) {
            logger.info("exception", e.getCause().getMessage());
        }

        return locationEntities;

    }

    private void validatePayload(UserLocationPayload userLocationPayload) {

        if (Objects.isNull(userLocationPayload.getLatLng()) || Objects.isNull(userLocationPayload.getLatLng().lat) || Objects.isNull(userLocationPayload.getLatLng().lng))
            return;
    }

    public void addLocation(CookLocationPayload cookLocationPayload) {

        CookDetailsEntity locationEntity = new CookDetailsEntity();
        locationEntity.setCookId(cookLocationPayload.getCookId());
        locationEntity.setCity(cookLocationPayload.getCity());
        locationEntity.setCountry(cookLocationPayload.getCountry());
        LocationInfo locationInfo = new LocationInfo();
        ArrayList<Double> coordinates = new ArrayList<>();
        coordinates.add(cookLocationPayload.getLatLng().lng);
        coordinates.add(cookLocationPayload.getLatLng().lat);
        locationInfo.setCoordinates(coordinates);
        locationEntity.setLocationInfo(locationInfo);
        mongoTemplate.save(locationEntity);
    }
}

