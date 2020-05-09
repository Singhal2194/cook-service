package com.cook.CookServer.service;

import com.cook.CookServer.dto.LoginPayload;
import com.cook.CookServer.model.CookDetailsEntity;
import com.cook.CookServer.repository.CookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.cook.CookServer.app.Constants.*;

//import static com.cook.authentication.app.Constants.*;

@Component
public class LoginService {

    @Autowired
    CookDetailsRepository cookDetailsRepository;

    public Map<String, Object> login(LoginPayload loginPayload) {
        Map<String, Object> response = new HashMap<>();
        List<CookDetailsEntity> cookDetailsEntities = cookDetailsRepository.findByPhoneNumber(loginPayload.getPhoneNumber());
        if (Objects.isNull(cookDetailsEntities) || StringUtils.isEmpty(cookDetailsEntities)) {
            response.put(STATUS, STATUS_FAILURE);
            response.put(REASON, NUMBER_NOT_REGISTERED);
            return response;
        }
        response.put(STATUS, STATUS_SUCCESS);
        response.put(COOKID, cookDetailsEntities.get(0).getCookId());
        return response;

    }


}
