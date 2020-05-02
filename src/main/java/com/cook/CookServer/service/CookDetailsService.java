//package com.cook.authentication.service;
//
//import com.cook.authentication.dto.CookDetails;
//import com.cook.authentication.model.CookEntity;
//import com.cook.authentication.repository.CookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class CookDetailsService {
//
//
//    @Autowired
//    CookRepository cookRepository;
//
//
//    public CookDetails getCookDetails(String id) {
//
//        CookDetails cookDetails = new CookDetails();
//        CookEntity cookEntity = cookRepository.findByCookId(id);
//        cookDetails.setFirstName(cookEntity.getFirstName());
//        cookDetails.setLastName(cookEntity.getLastName());
//        cookDetails.setCity(cookEntity.getCity());
//        cookDetails.setEmailId(cookEntity.getEmailId());
//        cookDetails.setAadharNumber(cookEntity.getAadharNumber());
//        cookDetails.setPhoneNumber(cookEntity.getPhoneNumber());
//        cookDetails.setRatings(cookEntity.getRatings());
//        return cookDetails;
//    }
//}
////no of bookings
////speciality
////age
////incentives
////earning
////image url
