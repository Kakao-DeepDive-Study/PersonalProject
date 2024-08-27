package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EVChargeRepository extends JpaRepository<EVCharge, Long> {
}
