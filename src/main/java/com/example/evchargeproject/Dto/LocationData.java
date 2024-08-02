package com.example.evchargeproject.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationData {
    private double latitude;
    private double longitude;
    private String address;
}
