package com.cook.CookServer.service;
import com.cook.CookServer.dto.CookDetails;
import com.cook.CookServer.model.CookEntity;
import com.cook.CookServer.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookDetailsService {


    @Autowired
    CookRepository cookRepository;


    public CookDetails getCookDetails(CookEntity cookEntity) {

        CookDetails cookDetails = new CookDetails();
        cookDetails.setFirstName(cookEntity.getFirstName());
        cookDetails.setLastName(cookEntity.getLastName());
        cookDetails.setCity(cookEntity.getCity());
        cookDetails.setEmailId(cookEntity.getEmailId());
        cookDetails.setAadharNumber(cookEntity.getAadharNumber());
        cookDetails.setPhoneNumber(cookEntity.getPhoneNumber());
        cookDetails.setRatings(cookEntity.getRatings());
        return cookDetails;
    }
}
//no of bookings
//speciality
//age
//incentives
//earning
//image url
