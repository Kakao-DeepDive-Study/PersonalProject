package com.example.evchargeproject.domain.entity.evcharge;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @NotNull
    @Column(name = "city_name")
    private String cityName;

    public static City createCity(String cityName){
        City city = new City();
        city.cityName = cityName;
        return city;
    }
}
