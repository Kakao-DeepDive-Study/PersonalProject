package com.example.evchargeproject.domain.entity.member;

public enum MemberRole {
    ROLE_USER("사용자"), ROLE_OWNER("관리자");

    private String role;

    MemberRole(String role){
        this.role = role;
    }
}