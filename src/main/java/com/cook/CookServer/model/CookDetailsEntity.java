package com.cook.CookServer.model;

import com.cook.CookServer.dto.LocationInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="cook_details")
@Getter
@Setter
public class CookDetailsEntity {

    @Id
    @Field
    private String id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private String phoneNumber;

    @Field
    private String emailId;

    @Field
    private String aadharNumber;

    @Field
    private String ratings;

    @Field
    private String cookId;

    @Field
    private String city;

    @Field
    private String country;

    @Field
    private LocationInfo locationInfo;

}

