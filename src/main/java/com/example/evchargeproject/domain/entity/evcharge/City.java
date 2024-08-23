package com.example.evchargeproject.domain.entity.evcharge;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name")
    private String cityName;
}
