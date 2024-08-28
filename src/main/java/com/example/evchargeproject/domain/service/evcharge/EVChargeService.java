package com.example.evchargeproject.domain.service.evcharge;

import com.example.evchargeproject.domain.dto.common.CommonSuccessDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeAddressDTO;
import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.member.Member;
import com.example.evchargeproject.domain.repository.evcharge.EVChargeRepository;
import com.example.evchargeproject.domain.repository.evcharge.FavoriteRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
@Slf4j
public class EVChargeService {

    private final EVChargeRepository evChargeRepository;
    private final FavoriteRepository favoriteRepository;

    public List<EVChargeAddressDTO> getEVChargeAddresses(Long memberId, String address){
        String[] addressArray = address.split(" ");
        String cityName = addressArray[0];
        System.out.println("cityName : " + cityName);
        String countryName = addressArray[1];
        System.out.println("countryName : " + countryName);
        List<EVChargeAddressDTO> evChargeAddresses = new ArrayList<>();
        List<EVCharge> evCharges = evChargeRepository.findEVChargesByCityAndCountry(cityName, countryName);

        for(EVCharge evCharge : evCharges){
            boolean favoriteYn = false;
            if(favoriteRepository.existsFavoriteByMemberAndEvCharge(memberId, evCharge.getEvcId())>0){
                favoriteYn = true;
            }
            evChargeAddresses.add(EVChargeAddressDTO.fromEntity(evCharge, favoriteYn));
        }

        return evChargeAddresses;
    }

    public CommonSuccessDto favoriteOrNotEVCharge(Long memberId, Long evcId){


        return CommonSuccessDto.fromEntity(true);
    }
}
