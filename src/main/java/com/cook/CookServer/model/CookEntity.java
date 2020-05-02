package com.cook.CookServer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cook_info")
@Getter
@Setter
public class CookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(columnDefinition="char(36)", name="first_name")
    private String firstName;
    @Column(columnDefinition="char(36)", name="last_name")
    private String lastName;
    @Column(columnDefinition="char(36)", name="email_id")
    private String emailId;
    @Column(columnDefinition="char(36)", name="phone_number")
    private String phoneNumber;
    @Column(columnDefinition="char(36)", name="city")
    private String city;
    @Column(columnDefinition="char(36)", name="aadhar_number")
    private String aadharNumber;
    @Column(columnDefinition="char(36)", name="cook_id")
    private String cookId;
    @Column(columnDefinition="char(36)", name="ratings")
    private String ratings;

}
