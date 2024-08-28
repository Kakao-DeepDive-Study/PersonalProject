package com.example.evchargeproject.domain.entity.evcharge;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "evcharge_type")
public class EVChargeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evc_type_id")
    private Long evcTypeId;

    @NotNull
    @Column(name = "model_category_major")
    private String modelCategoryMajor;

    @NotNull
    @Column(name = "evc_type_name")
    private String evcTypeName;


    @Column(name = "evc_fast_charge")
    private String evcFastCharge;


    public static EVChargeType createEVChargeType(String modelCategoryMajor, String evcTypeName, String evcFastCharge){
        EVChargeType evChargeType = new EVChargeType();
        evChargeType.modelCategoryMajor = modelCategoryMajor;
        evChargeType.evcTypeName = evcTypeName;
        evChargeType.evcFastCharge = evcFastCharge;
        return evChargeType;
    }
}
