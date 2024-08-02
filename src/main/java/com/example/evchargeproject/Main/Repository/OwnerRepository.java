package com.example.evchargeproject.Main.Repository;

import com.example.evchargeproject.Dto.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}
