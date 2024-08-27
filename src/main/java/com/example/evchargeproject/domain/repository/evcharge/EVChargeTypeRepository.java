package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVChargeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EVChargeTypeRepository extends JpaRepository<EVChargeType, Long> {
}
