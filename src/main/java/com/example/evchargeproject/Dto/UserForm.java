package com.example.evchargeproject.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserForm {
    String name;
    String userId;
    String password;
    String email;
    String phoneNumber;
    String address;
    int carTypeId;
    boolean locationInformation;
    boolean personalInformation;
}
