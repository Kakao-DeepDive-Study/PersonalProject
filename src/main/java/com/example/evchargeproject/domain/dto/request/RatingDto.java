package com.example.evchargeproject.domain.dto.request;

public record RatingDto(
        Long memberId,
        Long evcId,
        int score
) {
}
