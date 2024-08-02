package com.example.evchargeproject.Main.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AddressService {
    private final String uri = "https://dapi.kakao.com/v2/local/search/address.json";

//    @Value("${kakao.api.key}")
    private String kakaoLocalKey;

    public String getCoordinate(String address){

        try {
            String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }
}
