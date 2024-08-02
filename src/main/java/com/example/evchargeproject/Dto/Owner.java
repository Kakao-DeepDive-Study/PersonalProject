package com.example.evchargeproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "owner")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ownerId;
    @Column(nullable = false)
    int chargeStationId;
    @Column(length = 50, nullable = false)
    String name;
    @Column(length = 255, nullable = false, unique = true)
    String userId;
    @Column(length = 255, nullable = false)
    String password;
    @Column(length = 255, nullable = false)
    String email;
    @Column(length = 255, nullable = false)
    String phoneNumber;
    @Column(length = 255, nullable = false)
    String address;
    @Column
    boolean locationInformation;
    @Column
    boolean personalInformation;
}
