package com.example.evchargeproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "evchargedetail")
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class EVChargeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long chargeStationDetailId;
    String largeFacility;
    String smallFacility;
    String largeModel;
    String smallModel;
    String largeOrganization;
    String smallOrganization;
    String chargeDetailId;
    Long evchargeFK;

}
