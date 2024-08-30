package com.example.evchargeproject.domain.service.evcharge;

import com.example.evchargeproject.domain.dto.common.CommonSuccessDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeAddressDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeDetailsListDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeListDto;
import com.example.evchargeproject.domain.entity.evcharge.City;
import com.example.evchargeproject.domain.entity.evcharge.Country;
import com.example.evchargeproject.domain.entity.evcharge.EVCharge;
import com.example.evchargeproject.domain.entity.favorite.Favorite;
import com.example.evchargeproject.domain.entity.member.Member;
import com.example.evchargeproject.domain.entity.rating.Rating;
import com.example.evchargeproject.domain.exception.CommonException;
import com.example.evchargeproject.domain.repository.evcharge.*;
import com.example.evchargeproject.domain.repository.member.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.evchargeproject.domain.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(readOnly = true)
@Slf4j
public class EVChargeService {
    private final MemberRepository memberRepository;
    private final RatingRepository ratingRepository;
    private final EVChargeRepository evChargeRepository;
    private final FavoriteRepository favoriteRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<EVChargeAddressDto> getEVChargeAddresses(Long memberId, String address){
        String[] addressArray = address.split(" ");
        String cityName = addressArray[0];
        System.out.println("cityName : " + cityName);
        String countryName = addressArray[1];
        System.out.println("countryName : " + countryName);
        List<EVChargeAddressDto> evChargeAddresses = new ArrayList<>();
        List<EVCharge> evCharges = evChargeRepository.findEVChargesByCityAndCountry(cityName, countryName);

        for(EVCharge evCharge : evCharges){
            boolean favoriteYn = false;
            if(favoriteRepository.existsFavoriteByMemberAndEvCharge(memberId, evCharge.getEvcId())>0){
                favoriteYn = true;
            }
            evChargeAddresses.add(EVChargeAddressDto.fromEntity(evCharge, favoriteYn));
        }

        return evChargeAddresses;
    }

    @Transactional
    public CommonSuccessDto favoriteOrNotEVCharge(Long memberId, Long evcId){
        if(favoriteRepository.existsFavoriteByMemberAndEvCharge(memberId, evcId) > 0){
            favoriteRepository.deleteFavoriteByMemberAndEvCharge(memberId, evcId);
            return CommonSuccessDto.fromEntity(true);
        }

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new CommonException(NOT_FOUND_MEMBER));
        EVCharge evCharge = evChargeRepository.findById(evcId).orElseThrow(() -> new CommonException(NOT_FOUND_EVCHARGE));
        Favorite favorite = Favorite.createFavorite(member, evCharge);
        favoriteRepository.save(favorite);
        return CommonSuccessDto.fromEntity(true);
    }

    @Transactional
    public CommonSuccessDto ratingEVCharge(Long memberId, Long evcId, int score){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new CommonException(NOT_FOUND_MEMBER));
        EVCharge evCharge = evChargeRepository.findById(evcId).orElseThrow(() -> new CommonException(NOT_FOUND_EVCHARGE));

        Rating rating = Rating.createRating(member, evCharge, score);
        ratingRepository.save(rating);
        return CommonSuccessDto.fromEntity(true);
    }

    public List<EVChargeListDto> evChargeList(Long memberId, Long cityId, Long countryId){
        City city = cityRepository.findById(cityId).orElseThrow(() -> new CommonException(NOT_FOUND_CITY));
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new CommonException(NOT_FOUND_COUNTRY));

        List<EVCharge> evCharges = evChargeRepository.findEVChargesByCityAndCountry(city.getCityName(), country.getCountryName());
        return evCharges.stream().map(EVChargeListDto::fromEntity).toList();
    }

    public EVChargeDetailsListDto evChargeDetailsList(Long memberId, Long evcId){
        EVCharge evCharge = evChargeRepository.findById(evcId).orElseThrow(() -> new CommonException(NOT_FOUND_EVCHARGE));
        boolean favoriteYn = false;
        if(favoriteRepository.existsFavoriteByMemberAndEvCharge(memberId, evCharge.getEvcId())>0){
            favoriteYn = true;
        }
        return EVChargeDetailsListDto.fromEntity(evCharge, favoriteYn);
    }
}
