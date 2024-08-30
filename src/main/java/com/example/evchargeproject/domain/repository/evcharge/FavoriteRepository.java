package com.example.evchargeproject.domain.repository.evcharge;

import com.example.evchargeproject.domain.entity.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query("select count(f) from Favorite f" +
            " where f.member.memberId = :memberId and f.evCharge.evcId = :evcId")
    Long existsFavoriteByMemberAndEvCharge(@Param("memberId") Long memberId, @Param("evcId") Long evcId);

    @Modifying
    @Query("delete from Favorite f " +
        " where f.member.memberId = :memberId and f.evCharge.evcId = :evcId")
    void deleteFavoriteByMemberAndEvCharge(@Param("memberId") Long memberId, @Param("evcId") Long evcId);
}
