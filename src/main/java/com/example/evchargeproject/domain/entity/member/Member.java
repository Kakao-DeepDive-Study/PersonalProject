package com.example.evchargeproject.domain.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "member_name")
    private String memberName;

    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Column(name = "phone", length = 13)
    private String phone;

    @Column(name = "car_type")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "car_type_id")
    private CarType carType;

    @Column(name = "home_address")
    private String homeAddress;

    @Column(name = "office_address")
    private String officeAddress;

    @Column(name = "profile_url")
    private String profile_url;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role")
    private MemberRole memberRole;


    public static Member createMember(String email, String password, String memberName, String nickname, String phone){
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.memberName = memberName;
        member.nickname = nickname;
        member.phone = phone;
        member.carType = null;
        member.homeAddress = null;
        member.officeAddress = null;
        member.memberRole = MemberRole.ROLE_USER;
        return member;
    }
}
