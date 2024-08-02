package com.example.evchargeproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
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
    @Column(nullable = false)
    int carTypeId;
    @Column
    boolean locationInformation;
    @Column
    boolean personalInformation;



}
