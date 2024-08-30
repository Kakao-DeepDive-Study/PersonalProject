package com.example.evchargeproject.domain.dto.response.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.evcharge.EVChargeDetail;
import com.example.evchargeproject.domain.entity.evcharge.EVChargeType;
import com.example.evchargeproject.domain.entity.favorite.Favorite;
import lombok.Builder;

@Builder
public record EVChargeDetailsDto(
        Long evcDetailId,
        int installationYear,
        String operatorCategoryMajor,
        String operatorCategoryMinor,
        boolean userRestriction,
        int evcCount,
        Long evcTypeId,
        String modelCategoryMajor,
        String evcTypeName,
        String evcFastCharge
) {
    public static EVChargeDetailsDto fromEntity(EVChargeDetail evChargeDetail){
        return EVChargeDetailsDto.builder()
                .evcDetailId(evChargeDetail.getEvcDetailId())
                .installationYear(evChargeDetail.getInstallationYear())
                .operatorCategoryMajor(evChargeDetail.getOperatorCategoryMajor())
                .operatorCategoryMinor(evChargeDetail.getOperatorCategoryMinor())
                .userRestriction(evChargeDetail.isUserRestriction())
                .evcCount(evChargeDetail.getEvcCount())
                .evcTypeId(evChargeDetail.getEvChargeType().getEvcTypeId())
                .modelCategoryMajor(evChargeDetail.getEvChargeType().getModelCategoryMajor())
                .evcTypeName(evChargeDetail.getEvChargeType().getEvcTypeName())
                .evcFastCharge(evChargeDetail.getEvChargeType().getEvcFastCharge())
                .build();
    }
}
