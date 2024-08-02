package com.example.evchargeproject.Main.Controller;

import com.example.evchargeproject.Dto.EVChargeDouble;
import com.example.evchargeproject.Main.Service.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {
    private final MainServiceImpl mainService;

    @GetMapping("/test/home")
    public List<EVChargeDouble> Home(@SessionAttribute(name = "address", required = false) String address){
        List<EVChargeDouble> evChargeDoubleList = mainService.getEVChargeByAddress2(address);

        System.out.println("Test Controller의 address : "+address);
        return evChargeDoubleList;
    }
}
