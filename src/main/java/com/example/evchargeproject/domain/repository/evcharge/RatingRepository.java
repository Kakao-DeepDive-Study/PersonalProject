package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
