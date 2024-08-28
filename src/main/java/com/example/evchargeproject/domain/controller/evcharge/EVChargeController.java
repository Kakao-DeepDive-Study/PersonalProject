package com.example.evchargeproject.domain.controller.evcharge;

import com.example.evchargeproject.domain.dto.common.CommonSuccessDto;
import com.example.evchargeproject.domain.dto.global.ResponseDto;
import com.example.evchargeproject.domain.dto.response.evcharge.EVChargeAddressDTO;
import com.example.evchargeproject.domain.service.evcharge.EVChargeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/")
public class EVChargeController {

    private final EVChargeService evChargeService;

    @GetMapping(value = "sample")
    public String home(){
        return "sample";
    }

    @GetMapping(value = "sendLocation")
    @ResponseBody  // JSON 형태의 응답을 보냅니다.
    public List<EVChargeAddressDTO> receiveLocation(@RequestParam(name = "address") String address, @RequestParam(name = "memberId") Long memberId){
        log.info("Received address: {}", address);
        System.out.println("-------------------------");
        System.out.println("address : " + address);
        System.out.println("-------------------------");
        return evChargeService.getEVChargeAddresses(memberId, address);
    }

    @PostMapping(value = "favorite")
    public ResponseDto<CommonSuccessDto> favoriteEVCharge(@RequestParam(name = "memberId") Long memberId, @RequestParam(name = "evcId") Long evcId){
        log.info("------favoriteEVCharge------");
//        return ResponseDto.ok();
    }
}
