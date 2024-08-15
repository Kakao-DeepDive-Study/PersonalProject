package com.example.evchargeproject.Main.Controller;

import com.example.evchargeproject.Main.Service.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {
    private final MainServiceImpl mainService;

    @GetMapping("/test/home")
    public List<EVChargeDouble> Home(@SessionAttribute(required = false) String address){
        List<EVChargeDouble> evChargeDoubleList = mainService.getEVChargeByAddress2(address);

        System.out.println("Test Controller의 address : "+address);
        return evChargeDoubleList;
    }
}
