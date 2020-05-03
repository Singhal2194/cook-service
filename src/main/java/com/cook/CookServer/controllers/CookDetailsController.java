package com.cook.CookServer.controllers;

import com.cook.CookServer.app.Constants;
import com.cook.CookServer.dto.CookDetails;
import com.cook.CookServer.dto.ErrorMessagePayload;
import com.cook.CookServer.model.CookEntity;
import com.cook.CookServer.repository.CookRepository;
import com.cook.CookServer.service.CookDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.core.Response;

@RestController
public class CookDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(CookDetailsController.class);
    @Autowired
    CookRepository cookRepository;
    @Autowired
    private CookDetailsService cookDetailsService;

    @GetMapping(path = "/profile", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Object> getProfile(@NotBlank @RequestParam("cook_id") String id) {

        logger.info("get Request with request object:{}", id);

        CookEntity cookEntity = cookRepository.findByCookId(id);
        if (cookEntity == null) {
            ErrorMessagePayload errorMessagePayload = new ErrorMessagePayload();
            errorMessagePayload.setError(Constants.COOKID_NOT_FOUND);
            errorMessagePayload.setReason("no records associated with the given cook id");
           // return Response.status(Response.Status.BAD_REQUEST).entity(errorMessagePayload).build().getEntity();
        return new ResponseEntity(errorMessagePayload, HttpStatus.BAD_REQUEST);
        }
        CookDetails cookDetails = cookDetailsService.getCookDetails(cookEntity);
        return new ResponseEntity(cookDetails, HttpStatus.OK);
    }
}
