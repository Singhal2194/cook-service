package com.cook.CookServer.repository;


import com.cook.CookServer.model.CookDetailsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookDetailsRepository extends MongoRepository<CookDetailsEntity, String> {


    List<CookDetailsEntity>  findBycookId(String cookId);
    List<CookDetailsEntity> findByPhoneNumber(String cookId);
}

