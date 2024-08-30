package com.example.evchargeproject.domain.dto.response.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.evcharge.EVChargeDetail;
import lombok.Builder;
import java.util.List;

@Builder
public record EVChargeDetailsListDto(
    EVChargeAddressDto evChargeAddressDto,
    List<EVChargeDetailsDto> evChargeDetailsDtos
) {
    public static EVChargeDetailsListDto fromEntity(EVCharge evCharge, boolean favoriteYn){
        return EVChargeDetailsListDto.builder()
                .evChargeAddressDto(EVChargeAddressDto.fromEntity(evCharge, favoriteYn))
                .evChargeDetailsDtos(evCharge.getEvChargeDetailList().stream().map(EVChargeDetailsDto::fromEntity).toList())
                .build();
    }
}
