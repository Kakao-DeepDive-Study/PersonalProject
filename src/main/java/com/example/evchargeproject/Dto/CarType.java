package com.example.evchargeproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cartype")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long carTypeId;
    String carName;
    int chargingType;
}
