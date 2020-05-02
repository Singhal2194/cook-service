package com.cook.CookServer.service;

import com.cook.CookServer.dto.LoginPayload;
import com.cook.CookServer.model.CookEntity;
import com.cook.CookServer.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.cook.CookServer.app.Constants.*;

//import static com.cook.authentication.app.Constants.*;

@Component
public class LoginService {
    @Autowired
    CookRepository cookRepository;

    public Map<String, Object> login(LoginPayload loginPayload) {
        Map<String, Object> response = new HashMap<>();
        CookEntity cookEntity = cookRepository.findByPhoneNumber(loginPayload.getPhoneNumber());
        if(Objects.isNull(cookEntity)){
            response.put(STATUS, STATUS_FAILURE);
            response.put(REASON, NUMBER_NOT_REGISTERED);
            return response;
        }
        response.put(STATUS, STATUS_SUCCESS);
        response.put(COOKID,cookEntity.getCookId());
        return response;

    }


}
