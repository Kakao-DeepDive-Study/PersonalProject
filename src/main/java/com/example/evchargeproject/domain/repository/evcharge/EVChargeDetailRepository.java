package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVChargeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EVChargeDetailRepository extends JpaRepository<EVChargeDetail, Long> {
}
