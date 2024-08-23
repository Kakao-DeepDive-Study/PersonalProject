package com.example.evchargeproject.domain.entity.reservation;

import com.example.evchargeproject.domain.entity.evcharge.EVChargeDetail;
import com.example.evchargeproject.domain.entity.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = CASCADE)
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "evc_detail_id")
    @OnDelete(action = CASCADE)
    private EVChargeDetail evchargeDetail;

    @NotNull
    @Column(name = "usage_date_time")
    private LocalDateTime usageDateTime;

    @NotNull
    @Column(name = "reservation_date_time")
    private LocalDateTime reservationDateTime;

}
