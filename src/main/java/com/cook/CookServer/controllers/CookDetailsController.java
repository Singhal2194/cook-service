//package com.cook.authentication.controllers;
//
//import com.cook.authentication.dto.CookDetails;
//import com.cook.authentication.service.CookDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path(value = "/v1/api")
//public class CookDetailsController {
//
//
//    @Autowired
//    CookDetailsService cookDetailsService;
//
//    @GET
//    @Path("/get")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getCookProfile(String cookId) {
//
//        CookDetails cookDetails = cookDetailsService.getCookDetails(cookId);
//        return Response.ok(cookDetails).build();
//    }
//
//
//}
