package com.example.evchargeproject.domain.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "car_type")
public class CarType {
    @Id
    @Column(name = "car_type_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long carTypeId;

    @NotNull
    @Column(name = "car_name")
    private String carName;
}
