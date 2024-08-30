package com.example.evchargeproject.domain.dto.response.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import lombok.Builder;

@Builder
public record EVChargeListDto(
        Long evcId,
        String evcName,
        String cityName,
        String countryName,
        String detailAddress,
        String facilityTypeMajor,
        String facilityTypeMinor,
        Double ratingAvg
) {

    public static EVChargeListDto fromEntity(EVCharge evCharge){
        return EVChargeListDto.builder()
                .evcId(evCharge.getEvcId())
                .evcName(evCharge.getEvcName())
                .cityName(evCharge.getCity().getCityName())
                .countryName(evCharge.getCountry().getCountryName())
                .detailAddress(evCharge.getDetailAddress())
                .facilityTypeMajor(evCharge.getFacilityTypeMajor())
                .facilityTypeMinor(evCharge.getFacilityTypeMinor())
                .ratingAvg(evCharge.getRatingAvg())
                .build();
    }
}
