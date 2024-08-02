package com.example.evchargeproject.Main.Repository;

import com.example.evchargeproject.Dto.EVChargeDouble;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EVChargeDoubleRepository extends JpaRepository<EVChargeDouble,Long> {

    // 시, 도로 데이터 가져오기
    Page<EVChargeDouble> findByAddressContains(String address, Pageable pageable);

    List<EVChargeDouble> findByAddressContains(String address);

    Optional<EVChargeDouble> findById(Long id);

    Page<EVChargeDouble> findEVChargeDoublesBy(String address, Pageable pageable);
}
