package com.example.evchargeproject.domain.entity.evcharge;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @NotNull
    @Column(name = "country_name")
    private String countryName;

    public static Country createCountry(String countryName){
        Country country = new Country();
        country.countryName = countryName;
        return country;
    }


}
