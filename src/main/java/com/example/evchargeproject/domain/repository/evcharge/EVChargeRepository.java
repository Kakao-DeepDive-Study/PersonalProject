package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EVChargeRepository extends JpaRepository<EVCharge, Long> {

    @Query("select e from EVCharge e" +
            " where e.city.cityName Like :cityName%" +
            " and e.country.countryName = :countryName")
    List<EVCharge> findEVChargesByCityAndCountry(@Param("cityName") String cityName, @Param("countryName") String countryName);

}
