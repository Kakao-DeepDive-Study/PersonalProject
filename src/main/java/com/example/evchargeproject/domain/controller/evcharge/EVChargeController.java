package com.example.evchargeproject.domain.controller.evcharge;

import com.example.evchargeproject.domain.dto.common.CommonSuccessDto;
import com.example.evchargeproject.domain.dto.global.ResponseDto;
import com.example.evchargeproject.domain.dto.request.FavoriteDto;
import com.example.evchargeproject.domain.dto.request.RatingDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeAddressDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeListDto;
import com.example.evchargeproject.domain.service.evcharge.EVChargeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/evcharge")
public class EVChargeController {

    private final EVChargeService evChargeService;

    @GetMapping(value = "/sample")
    public String home(){
        return "sample";
    }

    @GetMapping(value = "/sendLocation")
    @ResponseBody  // JSON 형태의 응답을 보냅니다.
    public List<EVChargeAddressDto> receiveLocation(@RequestParam(name = "address") String address, @RequestParam(name = "memberId") Long memberId){
        log.info("Received address: {}", address);
        System.out.println("-------------------------");
        System.out.println("address : " + address);
        System.out.println("-------------------------");
        return evChargeService.getEVChargeAddresses(memberId, address);
    }

    @PostMapping(value = "/favorite")
    @ResponseBody
    public ResponseDto<CommonSuccessDto> favoriteEVCharge(@RequestBody FavoriteDto favoriteDto){
        log.info("------favoriteEVCharge------");

        return ResponseDto.created(evChargeService.favoriteOrNotEVCharge(favoriteDto.memberId(), favoriteDto.evcId()));
    }

    @PostMapping(value = "/rating")
    public ResponseDto<CommonSuccessDto> ratingEVCharge(@RequestBody RatingDto ratingDto){
        log.info("------ratingEVCharge------");

        return ResponseDto.created(evChargeService.ratingEVCharge(ratingDto.memberId(), ratingDto.evcId(), ratingDto.score()));
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<EVChargeListDto> evChargeList(@RequestParam(name = "memberId") Long memberId,
                                        @RequestParam(name = "cityId", required = false) Long cityId,
                                        @RequestParam(name = "countryId", required = false) Long countryId,
                                        Model model
    ){
        if(cityId == null){
            cityId = 1L; // default cityId
        }
        if(countryId == null){
            countryId = 1L; // default countryId
        }
//        model.addAttribute("evChargeList", evChargeService.evChargeList(memberId, cityId, countryId));
        return evChargeService.evChargeList(memberId, cityId, countryId);
    }


}
