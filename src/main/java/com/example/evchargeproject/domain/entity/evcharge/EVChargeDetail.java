package com.example.evchargeproject.domain.entity.evcharge;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static jakarta.persistence.FetchType.LAZY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ev_charge_detail")
public class EVChargeDetail {

    @Id
    @Column(name = "evc_detail_id")
    private Long evcDetailId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "evc_id")
    @OnDelete(action = CASCADE)
    private EVCharge evCharge;

    @NotNull
    @Column(name = "installation_year")
    private int installationYear;

    @NotNull
    @Column(name = "operator_category_major")
    private String operatorCategoryMajor;

    @NotNull
    @Column(name = "operator_category_minor")
    private String operatorCategoryMinor;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "evc_type_id")
    @OnDelete(action = CASCADE)
    private EVChargeType evcTypeId;

    @NotNull
    @Column(name = "user_restriction")
    @ColumnDefault(value = "0")
    private boolean userRestriction;
}
