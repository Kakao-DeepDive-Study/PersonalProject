package com.example.evchargeproject.Main.Repository;

import com.example.evchargeproject.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
