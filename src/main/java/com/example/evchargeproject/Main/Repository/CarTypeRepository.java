package com.example.evchargeproject.Main.Repository;

import com.example.evchargeproject.Dto.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, String> {
}
