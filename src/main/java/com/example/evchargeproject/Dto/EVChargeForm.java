package com.example.evchargeproject.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EVChargeForm {
    Long id;
    String address;
    String name;
    Long numberofevcharge;
    String largeFacility;
    String smallFacility;
    String largeModel;
    String smallModel;
    String largeOrganization;
    String smallOrganization;
    String chargeDetailId;
}
