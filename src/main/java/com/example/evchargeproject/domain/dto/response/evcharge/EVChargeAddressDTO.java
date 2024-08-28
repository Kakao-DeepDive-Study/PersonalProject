package com.example.evchargeproject.domain.dto.response.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import lombok.Builder;

@Builder
public record EVChargeAddressDTO(
        Long evcId,
        Double latitude,
        Double longitude,
        String evcName,
        String cityName,
        String countryName,
        String detailAddress,
        String facilityTypeMajor,
        String facilityTypeMinor,
        String evcImage,
        Double ratingAvg,
        boolean favoriteYn
) {
    public static EVChargeAddressDTO fromEntity(EVCharge evCharge, boolean favoriteYn){
        return EVChargeAddressDTO.builder()
                .evcId(evCharge.getEvcId())
                .latitude(evCharge.getLatitude())
                .longitude(evCharge.getLongitude())
                .evcName(evCharge.getEvcName())
                .cityName(evCharge.getCity().getCityName())
                .countryName(evCharge.getCountry().getCountryName())
                .detailAddress(evCharge.getDetailAddress())
                .facilityTypeMajor(evCharge.getFacilityTypeMajor())
                .facilityTypeMinor(evCharge.getFacilityTypeMinor())
                .evcImage(evCharge.getEvcImage())
                .ratingAvg(evCharge.getRatingAvg())
                .favoriteYn(favoriteYn)
                .build();
    }
}
