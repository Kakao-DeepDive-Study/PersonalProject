package com.example.evchargeproject.Main.Service;

import com.example.evchargeproject.Dto.EVChargeDetail;
import com.example.evchargeproject.Dto.EVChargeDouble;
import com.example.evchargeproject.Dto.EVChargeForm;
import com.example.evchargeproject.Main.Repository.EVChargeDetailRepository;
import com.example.evchargeproject.Main.Repository.EVChargeDoubleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final EVChargeDoubleRepository evChargeRepository;
    private final EVChargeDetailRepository evChargeDetailRepository;

    public String test(Long id){
        System.out.println(evChargeRepository.findById(id));
        return evChargeRepository.findById(id).toString();
    }

    // 시, 구 별 데이터 가져오기
    public Page<EVChargeDouble> getEVChargeByAddress(String trial, Pageable pageable){
        return evChargeRepository.findByAddressContains(trial,pageable);
    }

    public List<EVChargeDouble> getEVChargeByAddress2(String address){
        String[] locPostion = {};
        String trial = "경기도"+ " " + "화성시";
        List<EVChargeDouble> evChargeDoubleList = new ArrayList<EVChargeDouble>();
        if(address != null && !address.isEmpty()){
            locPostion = address.split(" ");
            if(locPostion[0].equals("서울")){
                locPostion[0] = "서울특별시";
            }else if(locPostion[0].equals("경기")){
                locPostion[0] = "경기도";
            }else if(locPostion[0].equals("충북")){
                locPostion[0] = "충청북도";
            }else if(locPostion[0].equals("충남")){
                locPostion[0] = "충청남도";
            }else if(locPostion[0].equals("경북")){
                locPostion[0] = "경상북도";
            }else if(locPostion[0].equals("경남")){
                locPostion[0] = "경상남도";
            }else if(locPostion[0].equals("강원특별자치도")){
                locPostion[0] = "강원도";
            }else if(locPostion[0].equals("대전")){
                locPostion[0] = "대전광역시";
            }else if(locPostion[0].equals("대구")){
                locPostion[0] = "대구광역시";
            }else if(locPostion[0].equals("부산")){
                locPostion[0] = "부산광역시";
            }else if(locPostion[0].equals("인천")){
                locPostion[0] = "인천광역시";
            }else if(locPostion[0].equals("울산")){
                locPostion[0] = "울산광역시";
            }else if(locPostion[0].equals("전북")){
                locPostion[0] = "전라북도";
            }else if(locPostion[0].equals("전남")){
                locPostion[0] = "전라남도";
            }


            if(locPostion.length >= 2){
                trial = locPostion[0]+ " " + locPostion[1];
                System.out.println("trial : "+ locPostion[0] + " " + locPostion[1]);
            }else {}
        }else{}
        return evChargeRepository.findByAddressContains(trial);
    };

    public List<EVChargeDouble> findAll(){
        return evChargeRepository.findAll();
    }

    @Transactional
    public Page<EVChargeDouble> getEvchargeList(Pageable pageable){
        return evChargeRepository.findAll(pageable);
    }

    public List<EVChargeForm> selectDetailEVCharge(Long id){
        Optional<EVChargeDouble> evChargeDoubleOptional = evChargeRepository.findById(id);
        List<EVChargeDetail> evChargeDetailList = evChargeDetailRepository.findByevchargeFK(id);

        List<EVChargeForm> evChargeFormList = new ArrayList<>();

        if(evChargeDoubleOptional.isPresent()){
            EVChargeDouble evChargeDouble = evChargeDoubleOptional.get();

            for(EVChargeDetail evChargeDetail : evChargeDetailList){
                EVChargeForm evChargeForm = new EVChargeForm();
                evChargeForm.setId(evChargeDouble.getId());
                evChargeForm.setAddress(evChargeDouble.getAddress());
                evChargeForm.setName(evChargeDouble.getName());
                evChargeForm.setNumberofevcharge(evChargeDouble.getNumberofevcharge());
                evChargeForm.setLargeFacility(evChargeDetail.getLargeFacility());
                evChargeForm.setSmallFacility(evChargeDetail.getSmallFacility());
                evChargeForm.setLargeModel(evChargeDetail.getLargeModel());
                evChargeForm.setSmallModel(evChargeDetail.getSmallModel());
                evChargeForm.setLargeOrganization(evChargeDetail.getLargeOrganization());
                evChargeForm.setSmallOrganization(evChargeDetail.getSmallOrganization());
                evChargeForm.setChargeDetailId(evChargeDetail.getChargeDetailId());

                evChargeFormList.add(evChargeForm);
            }
        }

        return evChargeFormList;
    }

    public Page<EVChargeDouble> paging(int page){
        return evChargeRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC,"id")));
    }
}
