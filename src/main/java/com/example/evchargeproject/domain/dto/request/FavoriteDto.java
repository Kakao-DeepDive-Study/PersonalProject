package com.example.evchargeproject.domain.dto.request;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.member.Member;
import lombok.Builder;

@Builder
public record FavoriteDto(
        Long memberId,
        Long evcId
) {

}
