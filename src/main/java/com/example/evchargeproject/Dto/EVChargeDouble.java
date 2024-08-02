package com.example.evchargeproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "evchargedouble")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EVChargeDouble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long udetailid;
    String address;
    String name;
    Long numberofevcharge;
}
