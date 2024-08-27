package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
