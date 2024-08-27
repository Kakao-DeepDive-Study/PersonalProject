package com.example.evchargeproject.domain.repository.member;

import com.example.evchargeproject.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
