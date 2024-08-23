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
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Id
    @Column(name = "country_name")
    private Long countryName;

}
