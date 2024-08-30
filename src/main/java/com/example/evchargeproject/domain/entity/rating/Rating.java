package com.example.evchargeproject.domain.entity.rating;

import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_id")
    private Long ratingId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @OnDelete(action = CASCADE)
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "evc_id")
    @OnDelete(action = CASCADE)
    private EVCharge evCharge;

    @NotNull
    @Column(name = "score")
    private int score;

    public static Rating createRating(Member member, EVCharge evCharge, int score) {
        Rating rating = new Rating();
        rating.member = member;
        rating.evCharge = evCharge;
        rating.score = score;
        return rating;
    }
}
