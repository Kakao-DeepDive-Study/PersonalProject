package com.example.evchargeproject.domain.entity.evcharge;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ev_charge")
public class EVCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evc_id")
    private Long evcId;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "city_id")
    @OnDelete(action = CASCADE)
    private City city;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "country_id")
    @OnDelete(action = CASCADE)
    private Country country;

    @NotNull
    @Column(name = "detail_address")
    private String detailAddress;

    @NotNull
    @Column(name = "evc_name")
    private String evcName;

    @NotNull
    @Column(name = "facility_type_major")
    private String facilityTypeMajor;

    @NotNull
    @Column(name = "facility_type_minor")
    private String facilityTypeMinor;

    @NotNull
    @Column(name = "latitude")
    private Double latitude;

    @NotNull
    @Column(name = "longitude")
    private Double longitude;

    @NotNull
    @Column(name = "rating_avg")
    @ColumnDefault(value = "0.0")
    private Double ratingAvg;

    @NotNull
    @Column(name = "evc_image")
    private String evcImage;

    @OneToMany(mappedBy = "evCharge", cascade = ALL)
    private List<EVChargeDetail> evChargeDetailList = new ArrayList<>();

    public static EVCharge createEVCharge(City city, Country country, String detailAddress, String evcName,
                                          String facilityTypeMajor, String facilityTypeMinor,
                                          Double latitude, Double longitude){
        EVCharge evCharge = new EVCharge();
        evCharge.city = city;
        evCharge.country = country;
        evCharge.detailAddress = detailAddress;
        evCharge.evcName = evcName;
        evCharge.facilityTypeMajor = facilityTypeMajor;
        evCharge.facilityTypeMinor = facilityTypeMinor;
        evCharge.latitude = latitude;
        evCharge.longitude = longitude;
        evCharge.ratingAvg = 0.0;
        evCharge.evcImage = "../assets/kakaoProfileDefault.jpeg";
        return evCharge;


    }
}

