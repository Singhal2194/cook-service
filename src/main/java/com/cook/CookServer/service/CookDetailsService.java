package com.cook.CookServer.service;

import com.cook.CookServer.dto.CookDetails;
import com.cook.CookServer.model.CookDetailsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CookDetailsService {


    public CookDetails getCookDetails(List<CookDetailsEntity> cookEntities) {

        CookDetailsEntity cookDetailsEntity = cookEntities.get(0);
        CookDetails cookDetails = new CookDetails();
        cookDetails.setFirstName(cookDetailsEntity.getFirstName());
        cookDetails.setLastName(cookDetailsEntity.getLastName());
        cookDetails.setCity(cookDetailsEntity.getCity());
        cookDetails.setEmailId(cookDetailsEntity.getEmailId());
        cookDetails.setAadharNumber(cookDetailsEntity.getAadharNumber());
        cookDetails.setPhoneNumber(cookDetailsEntity.getPhoneNumber());
        cookDetails.setRatings(cookDetailsEntity.getRatings());
        return cookDetails;
    }
}
//no of bookings
//speciality
//age
//incentives
//earning
//image url
