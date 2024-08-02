package com.example.evchargeproject.Main.Controller;

import com.example.evchargeproject.Dto.EVChargeDouble;
import com.example.evchargeproject.Dto.EVChargeForm;
import com.example.evchargeproject.Dto.LocationData;
import com.example.evchargeproject.Main.Repository.EVChargeDoubleRepository;
import com.example.evchargeproject.Main.Service.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final EVChargeDoubleRepository evChargeDoubleRepository;

    @Autowired
    private final MainServiceImpl mainService;

    @GetMapping("/home")
    public String Home(@SessionAttribute(name = "address", required = false) String address, Model model){
        List<EVChargeDouble> evChargeDoubleList = mainService.getEVChargeByAddress2(address);
        model.addAttribute("evChargeDoubleList",evChargeDoubleList);
        System.out.println("리스트 사이즈 : "+evChargeDoubleList.size());

        System.out.println(address);
        return "home";
    }

    @PostMapping("/sendLocation")
    public String SendLocation(@RequestParam String address, HttpServletRequest request){
        System.out.println("--------------------------------------------");
        System.out.println("SendLocation: " + address);
        System.out.println("--------------------------------------------");

        HttpSession session = request.getSession();
        session.setAttribute("address", address);
        return "home";
    }

    @GetMapping("/projectintro")
    public String Intro(){
        return "projectIntro";
    }


    @GetMapping("/list")
    public String List(Model model, @PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false, defaultValue = "") String region, @RequestParam(required = false, defaultValue = "") String city){
        switch (region){
                case "a":region="강원도";
                    break;
                case "b":region="경기도";
                    break;
                case "c":region="경상남도";
                    break;
                case "d":region="경상북도";
                    break;
                case "e":region="광주광역시";
                    break;
                case "f":region="대구광역시";
                    break;
                case "g":region="대전광역시";
                    break;
                case "h":region="부산광역시";
                    break;
                case "i":region="서울특별시";
                    break;
                case "j":region="세종특별자치시";
                    break;
                case "k":region="울산광역시";
                    break;
                case "l":region="인천광역시";
                    break;
                case "m":region="전라남도";
                    break;
                case "n":region="전라북도";
                    break;
                case "o":region="제주특별자치도";
                    break;
                case "p":region="충청남도";
                    break;
                case "q":region="충청북도";
                    break;

            }
            if(region.equals("도/특별시 선택") ){
                region = "";
                city = "";
            }
            String trial = region + " " + city;
        Page<EVChargeDouble> evChargeDoubles = mainService.getEVChargeByAddress(trial, pageable);

        int pageSize = 10;
        int currentPage = evChargeDoubles.getPageable().getPageNumber();
        int totalPages = evChargeDoubles.getTotalPages();
        int endPage = Math.min((currentPage / pageSize + 1) * pageSize, totalPages);
        int startPage = Math.max(1, endPage - pageSize + 1);

        model.addAttribute("evChargeDoubles", evChargeDoubles);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("region", region);
        model.addAttribute("city", city);
        return "list";
    }

    @GetMapping("/detail")
    public String DetailList(@RequestParam long id, Model model){
        List<EVChargeForm> evChargeFormList = mainService.selectDetailEVCharge(id);
        model.addAttribute("evChargeFormList",evChargeFormList);
        System.out.println("----------------------------------");
        System.out.println("-----------DetailList------------");
        System.out.println(evChargeFormList);
        System.out.println("----------------------------------");

        return "detail";
    }


}
