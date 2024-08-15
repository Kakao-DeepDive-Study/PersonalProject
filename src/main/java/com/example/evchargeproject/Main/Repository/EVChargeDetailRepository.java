package com.example.evchargeproject.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EVChargeDetailRepository extends JpaRepository<EVChargeDetail, Long> {
    List<EVChargeDetail> findByevchargeFK(Long evchargeFK);
}
