package com.example.evchargeproject.init;

import com.example.evchargeproject.domain.entity.evcharge.*;
import com.example.evchargeproject.domain.entity.member.Member;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitH2DB {

    private final InitService initService;

    @PostConstruct
    public void initDatabase(){
        log.info("Initialized Database");
        List<Member> members = initService.initMembers();
        List<City> cities = initService.initCity();
        List<Country> countries = initService.initCountry();
        List<EVCharge> evCharges = initService.initEVCharge(cities, countries);
        List<EVChargeType> evChargeTypes = initService.initEVChargeType();
        List<EVChargeDetail> evChargeDetails = initService.initEVChargeDetail(evCharges, evChargeTypes);
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    @Slf4j
    static class InitService{

        private final EntityManager em;

        private Member member1;
        private Member member2;
        private Member member3;
        private Member member4;

        private City city1;
        private City city2;

        private Country country1;
        private Country country2;
        private Country country3;

        private EVCharge evCharge1;
        private EVCharge evCharge2;
        private EVCharge evCharge3;
        private EVCharge evCharge4;
        private EVCharge evCharge5;

        private EVCharge evCharge6;
        private EVCharge evCharge7;
        private EVCharge evCharge8;
        private EVCharge evCharge9;
        private EVCharge evCharge10;

        private EVCharge evCharge11;
        private EVCharge evCharge12;
        private EVCharge evCharge13;
        private EVCharge evCharge14;
        private EVCharge evCharge15;


        private EVChargeType evChargeType1;
        private EVChargeType evChargeType2;
        private EVChargeType evChargeType3;
        private EVChargeType evChargeType4;
        private EVChargeType evChargeType5;
        private EVChargeType evChargeType6;
        private EVChargeType evChargeType7;
        private EVChargeType evChargeType8;
        private EVChargeType evChargeType9;
        private EVChargeType evChargeType10;
        private EVChargeType evChargeType11;
        private EVChargeType evChargeType12;
        private EVChargeType evChargeType13;
        private EVChargeType evChargeType14;
        private EVChargeType evChargeType15;
        private EVChargeType evChargeType16;
        private EVChargeType evChargeType17;
        private EVChargeType evChargeType18;
        private EVChargeType evChargeType19;
        private EVChargeType evChargeType20;
        private EVChargeType evChargeType21;
        private EVChargeType evChargeType22;
        private EVChargeType evChargeType23;
        private EVChargeType evChargeType24;

        public List<Member> initMembers(){
            List<Member> memberInfos = Arrays.asList(
                    Member.createMember("user1@example.com", "1234", "홍길동", "둘리", "010-0000-0000"),
                    Member.createMember("user2@example.com", "1234", "임창희", "짱구", "010-1111-1111"),
                    Member.createMember("user3@example.com", "1234", "구태형", "맹구", "010-2222-2222"),
                    Member.createMember("user4@example.com", "1234", "맹인호", "철수", "010-3333-3333"));

            for(Member member : memberInfos){
                em.persist(member);
            }
            return memberInfos;
        }

        public List<City> initCity(){
            List<City> cityInfos = Arrays.asList(
                    City.createCity("강원특별자치도"),
                    City.createCity("경기도"),
                    City.createCity("경상남도"),
                    City.createCity("경상북도"),
                    City.createCity("광주광역시"),
                    City.createCity("대구광역시"),
                    City.createCity("대전광역시"),
                    City.createCity("부산광역시"),
                    City.createCity("서울특별시"),
                    City.createCity("세종특별자치시"),
                    City.createCity("울산광역시"),
                    City.createCity("인천광역시"),
                    City.createCity("전라남도"),
                    City.createCity("전북특별자치도"),
                    City.createCity("제주특별자치도"),
                    City.createCity("충청남도"),
                    City.createCity("충청북도")
            );

            for(City city : cityInfos){
                em.persist(city);
            }
            return cityInfos;
        }

        public List<Country> initCountry(){
            List<Country> countryInfos = Arrays.asList(
                    Country.createCountry("강릉시"),
                    Country.createCountry("고성군"),
                    Country.createCountry("동해시"),
                    Country.createCountry("삼척시"),
                    Country.createCountry("속초시"),
                    Country.createCountry("양구군"),
                    Country.createCountry("양양군"),
                    Country.createCountry("영월군"),
                    Country.createCountry("원주시"),
                    Country.createCountry("인제군"),
                    Country.createCountry("정선군"),
                    Country.createCountry("철원군"),
                    Country.createCountry("춘천시"),
                    Country.createCountry("태백시"),
                    Country.createCountry("평창군"),
                    Country.createCountry("홍천군"),
                    Country.createCountry("화천군"),
                    Country.createCountry("횡성군"),
                    Country.createCountry("가평군"),
                    Country.createCountry("고양시"),
                    Country.createCountry("과천시"),
                    Country.createCountry("광명시"),
                    Country.createCountry("광주시"),
                    Country.createCountry("구리시"),
                    Country.createCountry("군포시"),
                    Country.createCountry("김포시"),
                    Country.createCountry("남양주시"),
                    Country.createCountry("동두천시"),
                    Country.createCountry("부천시"),
                    Country.createCountry("성남시"),
                    Country.createCountry("수원시"),
                    Country.createCountry("시흥시"),
                    Country.createCountry("안산시"),
                    Country.createCountry("안성시"),
                    Country.createCountry("안양시"),
                    Country.createCountry("양주시"),
                    Country.createCountry("양평군"),
                    Country.createCountry("여주시"),
                    Country.createCountry("연천군"),
                    Country.createCountry("오산시"),
                    Country.createCountry("용인시"),
                    Country.createCountry("의왕시"),
                    Country.createCountry("의정부시"),
                    Country.createCountry("이천시"),
                    Country.createCountry("파주시"),
                    Country.createCountry("평택시"),
                    Country.createCountry("포천시"),
                    Country.createCountry("하남시"),
                    Country.createCountry("화성시"),
                    Country.createCountry("거제시"),
                    Country.createCountry("거창군"),
                    Country.createCountry("김해시"),
                    Country.createCountry("남해군"),
                    Country.createCountry("밀양시"),
                    Country.createCountry("사천시"),
                    Country.createCountry("산청군"),
                    Country.createCountry("양산시"),
                    Country.createCountry("의령군"),
                    Country.createCountry("진주시"),
                    Country.createCountry("창녕군"),
                    Country.createCountry("창원시"),
                    Country.createCountry("통영시"),
                    Country.createCountry("하동군"),
                    Country.createCountry("함안군"),
                    Country.createCountry("함양군"),
                    Country.createCountry("합천군"),
                    Country.createCountry("경산시"),
                    Country.createCountry("경주시"),
                    Country.createCountry("고령군"),
                    Country.createCountry("구미시"),
                    Country.createCountry("군위군"),
                    Country.createCountry("김천시"),
                    Country.createCountry("문경시"),
                    Country.createCountry("봉화군"),
                    Country.createCountry("상주시"),
                    Country.createCountry("성주군"),
                    Country.createCountry("안동시"),
                    Country.createCountry("영덕군"),
                    Country.createCountry("영양군"),
                    Country.createCountry("영주시"),
                    Country.createCountry("영천시"),
                    Country.createCountry("예천군"),
                    Country.createCountry("울릉군"),
                    Country.createCountry("울진군"),
                    Country.createCountry("의성군"),
                    Country.createCountry("청도군"),
                    Country.createCountry("청송군"),
                    Country.createCountry("칠곡군"),
                    Country.createCountry("포항시"),
                    Country.createCountry("광산구"),
                    Country.createCountry("남구"),
                    Country.createCountry("동구"),
                    Country.createCountry("북구"),
                    Country.createCountry("서구"),
                    Country.createCountry("달서구"),
                    Country.createCountry("달성군"),
                    Country.createCountry("수성구"),
                    Country.createCountry("중구"),
                    Country.createCountry("대덕구"),
                    Country.createCountry("유성구"),
                    Country.createCountry("강서구"),
                    Country.createCountry("금정구"),
                    Country.createCountry("기장군"),
                    Country.createCountry("동래구"),
                    Country.createCountry("부산진구"),
                    Country.createCountry("사상구"),
                    Country.createCountry("사하구"),
                    Country.createCountry("수영구"),
                    Country.createCountry("연제구"),
                    Country.createCountry("영도구"),
                    Country.createCountry("해운대구"),
                    Country.createCountry("강남구"),
                    Country.createCountry("강동구"),
                    Country.createCountry("강북구"),
                    Country.createCountry("관악구"),
                    Country.createCountry("광진구"),
                    Country.createCountry("구로구"),
                    Country.createCountry("금천구"),
                    Country.createCountry("노원구"),
                    Country.createCountry("도봉구"),
                    Country.createCountry("동대문구"),
                    Country.createCountry("동작구"),
                    Country.createCountry("마포구"),
                    Country.createCountry("서대문구"),
                    Country.createCountry("서초구"),
                    Country.createCountry("성동구"),
                    Country.createCountry("성북구"),
                    Country.createCountry("송파구"),
                    Country.createCountry("양천구"),
                    Country.createCountry("영등포구"),
                    Country.createCountry("용산구"),
                    Country.createCountry("은평구"),
                    Country.createCountry("종로구"),
                    Country.createCountry("중랑구"),
                    Country.createCountry("세종특별자치시"),
                    Country.createCountry("울주군"),
                    Country.createCountry("강화군"),
                    Country.createCountry("계양구"),
                    Country.createCountry("남동구"),
                    Country.createCountry("미추홀구"),
                    Country.createCountry("부평구"),
                    Country.createCountry("연수구"),
                    Country.createCountry("옹진군"),
                    Country.createCountry("강진군"),
                    Country.createCountry("고흥군"),
                    Country.createCountry("곡성군"),
                    Country.createCountry("광양시"),
                    Country.createCountry("구례군"),
                    Country.createCountry("나주시"),
                    Country.createCountry("담양군"),
                    Country.createCountry("목포시"),
                    Country.createCountry("무안군"),
                    Country.createCountry("보성군"),
                    Country.createCountry("순천시"),
                    Country.createCountry("신안군"),
                    Country.createCountry("여수시"),
                    Country.createCountry("영광군"),
                    Country.createCountry("영암군"),
                    Country.createCountry("완도군"),
                    Country.createCountry("장성군"),
                    Country.createCountry("장흥군"),
                    Country.createCountry("진도군"),
                    Country.createCountry("함평군"),
                    Country.createCountry("해남군"),
                    Country.createCountry("화순군"),
                    Country.createCountry("고창군"),
                    Country.createCountry("군산시"),
                    Country.createCountry("김제시"),
                    Country.createCountry("남원시"),
                    Country.createCountry("무주군"),
                    Country.createCountry("부안군"),
                    Country.createCountry("순창군"),
                    Country.createCountry("완주군"),
                    Country.createCountry("익산시"),
                    Country.createCountry("임실군"),
                    Country.createCountry("장수군"),
                    Country.createCountry("전주시"),
                    Country.createCountry("정읍시"),
                    Country.createCountry("진안군"),
                    Country.createCountry("서귀포시"),
                    Country.createCountry("제주시"),
                    Country.createCountry("계룡시"),
                    Country.createCountry("공주시"),
                    Country.createCountry("금산군"),
                    Country.createCountry("논산시"),
                    Country.createCountry("당진시"),
                    Country.createCountry("보령시"),
                    Country.createCountry("부여군"),
                    Country.createCountry("서산시"),
                    Country.createCountry("서천군"),
                    Country.createCountry("아산시"),
                    Country.createCountry("예산군"),
                    Country.createCountry("천안시"),
                    Country.createCountry("청양군"),
                    Country.createCountry("태안군"),
                    Country.createCountry("홍성군"),
                    Country.createCountry("괴산군"),
                    Country.createCountry("단양군"),
                    Country.createCountry("보은군"),
                    Country.createCountry("영동군"),
                    Country.createCountry("옥천군"),
                    Country.createCountry("음성군"),
                    Country.createCountry("제천시"),
                    Country.createCountry("증평군"),
                    Country.createCountry("진천군"),
                    Country.createCountry("청주시"),
                    Country.createCountry("충주시")
            );

            for(Country country : countryInfos){
                em.persist(country);
            }
            return countryInfos;
        }

        public List<EVCharge> initEVCharge(List<City> cities, List<Country> countries){
            city1 = cities.get(0); // 강원도
            city2 = cities.get(1); // 경기도

            country1 = countries.get(0); // 강릉시
            country2 = countries.get(30); // 수원시
            country3 = countries.get(48); // 화성시

            List<EVCharge> evChargeInfos = Arrays.asList(
                    // 강원도 강릉시
                    EVCharge.createEVCharge(city1, country1, "경강로 1850", "홍제주유소", "상업시설", "주유소", 37.746091, 128.8724118),
                    EVCharge.createEVCharge(city1, country1, "경강로 1952-10", "한국교통안전공단 강릉검사소", "공공시설", "공공기관", 37.7473534, 128.8824514),
                    EVCharge.createEVCharge(city1, country1, "경강로 1952-14", "홍제동둔치공영주차장", "주차시설", "공영주차장", 37.74751647, 128.8825538),
                    EVCharge.createEVCharge(city1, country1, "경강로 1953", "홍제동 주민센터", "공공시설", "주민센터", 37.74834889, 128.8836393),
                    EVCharge.createEVCharge(city1, country1, "경강로 1991", "중부지방고용노동청 강릉지청", "공공시설", "관공서", 37.748965, 128.887606),
                    // 경기도 수원시
                    EVCharge.createEVCharge(city2, country2, "권선구 권중로 85", "수원시 권선2동주민센터", "공공시설", "주민센터", 37.25132394, 127.0297122),
                    EVCharge.createEVCharge(city2, country2, "권선구 금곡동 1125 서울JS프라자", "서울제이에스프라자", "기타시설", "기타", 37.2735435, 126.955518),
                    EVCharge.createEVCharge(city2, country2, "권선구 금곡동 1147", "호매실 호반베르디움더센트럴", "공동주택시설", "아파트", 37.27055224, 126.9513796),
                    EVCharge.createEVCharge(city2, country2, "권선구 금곡동 금곡로 190", "호매실지구대", "근린생활시설", "경찰서", 37.273166, 126.9515809),
                    EVCharge.createEVCharge(city2, country2, "권선구 금곡로 106", "호매실우성메디피아1", "공동주택시설", "사업장(사옥)", 37.2739733, 126.9419969),
                    // 경기도 화성시
                    EVCharge.createEVCharge(city2, country3, "봉담읍 와우로34번길 63 (신명아파트)", "봉담신명아파트1", "공동주택시설", "아파트", 37.21343279, 126.9727136),
                    EVCharge.createEVCharge(city2, country3, "봉담읍 와우로34번길 63 (신명아파트)", "봉담신명아파트2", "공동주택시설", "아파트", 37.21256766, 126.9721901),
                    EVCharge.createEVCharge(city2, country3, "봉담읍 와우로73번길 22", "해오름마을봉담그대가1단지아파트", "공동주택시설", "아파트", 37.2152439, 126.9748878),
                    EVCharge.createEVCharge(city2, country3, "봉담읍 와우로73번길 22", "봉담 임광그대가1단지", "공동주택시설", "아파트", 37.2155739, 126.9740439),
                    EVCharge.createEVCharge(city2, country3, "봉담읍 와우로73번길 6", "태천센터빌딩", "공동주택시설", "아파트", 37.214119, 126.97421)
            );

            for(EVCharge evcharge : evChargeInfos){
                em.persist(evcharge);
            }
            return evChargeInfos;
        }

        public List<EVChargeType> initEVChargeType(){
            List<EVChargeType> evChargeTypeInfos = Arrays.asList(
                    EVChargeType.createEVChargeType("급속", "AC3상", null),
                    EVChargeType.createEVChargeType("급속", "DC차데모", null),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상", null),
                    EVChargeType.createEVChargeType("급속", "DC차데모+DC콤보", null),
                    EVChargeType.createEVChargeType("급속", "DC차데모+DC콤보", "급속(50kW)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+DC콤보", "급속(100kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", null),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", "급속(50kW)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", "급속(100kW단독)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", "급속(100kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", "급속(100kW멀티)"),
                    EVChargeType.createEVChargeType("급속", "DC차데모+AC3상+DC콤보", "급속(200kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", null),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(100kW단독)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(100kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(200kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(300kW단독)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(300kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "급속(400kW동시)"),
                    EVChargeType.createEVChargeType("급속", "DC콤보", "초급속(350kW단독)"),
                    EVChargeType.createEVChargeType("완속", "AC완속", null),
                    EVChargeType.createEVChargeType("완속", "DC콤보(완속)", null),
                    EVChargeType.createEVChargeType("완속", "DC콤보(완속)", "완속(30kW단독)")
            );

            for (EVChargeType evChargeType : evChargeTypeInfos){
                em.persist(evChargeType);
            }

            return evChargeTypeInfos;
        }



        public List<EVChargeDetail> initEVChargeDetail(List<EVCharge> evCharges, List<EVChargeType> evChargeTypes){
            evCharge1 = evCharges.get(0);
            evCharge2 = evCharges.get(1);
            evCharge3 = evCharges.get(2);
            evCharge4 = evCharges.get(3);
            evCharge5 = evCharges.get(4);
            evCharge6 = evCharges.get(5);
            evCharge7 = evCharges.get(6);
            evCharge8 = evCharges.get(7);
            evCharge9 = evCharges.get(8);
            evCharge10 = evCharges.get(9);
            evCharge11 = evCharges.get(10);
            evCharge12 = evCharges.get(11);
            evCharge13 = evCharges.get(12);
            evCharge14 = evCharges.get(13);
            evCharge15 = evCharges.get(14);

            evChargeType13 = evChargeTypes.get(12);

            List<EVChargeDetail> evChargeDetailInfos = Arrays.asList(
                    EVChargeDetail.createEVChargeDetail(evCharge1,2024,"타기관","GS칼텍스",evChargeType13,true,2),
                    EVChargeDetail.createEVChargeDetail(evCharge2, 2023, "타기관", "현대엔지니어링", evChargeType13,true, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge3, 2023, "타기관", "GS차지비", evChargeType21,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge3, 2023, "타기관", "GS차지비", evChargeType13,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge4, 2017, "타기관(보조금)", "GS차지비", evChargeType21,true, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge5, 2023, "타기관(보조금)", "휴맥스이브이", evChargeType13,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge5, 2023, "타기관", "휴맥스이브이", evChargeType21,true, 2),

                    EVChargeDetail.createEVChargeDetail(evCharge6, 2022, "타기관", "GS차지비", evChargeType21,true, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge7, 2023, "타기관(보조금)", "GS차지비", evChargeType21,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge8, 2019, "타기관", "한국전력", evChargeType7,false, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge8, 2019, "타기관", "한국전력", evChargeType21,false, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge9, 2022, "환경부", "환경부(협회)", evChargeType14,true, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge10, 2024, "타기관", "GS차지비", evChargeType21,true, 2),

                    EVChargeDetail.createEVChargeDetail(evCharge11, 2018, "타기관(보조금)", "에버온", evChargeType21,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge12, 2018, "타기관(보조금)", "에버온", evChargeType21,true, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge13, 2022, "타기관(보조금)", "GS차지비", evChargeType21,false, 6),
                    EVChargeDetail.createEVChargeDetail(evCharge13, 2023, "타기관(보조금)", "GS차지비", evChargeType21,true, 1),
                    EVChargeDetail.createEVChargeDetail(evCharge13, 2023, "타기관(보조금)", "GS차지비", evChargeType21,false, 2),
                    EVChargeDetail.createEVChargeDetail(evCharge14, 2023, "타기관", "한국전자금융", evChargeType21,false, 3),
                    EVChargeDetail.createEVChargeDetail(evCharge14, 2024, "타기관", "한국전자금융", evChargeType21,false, 6),
                    EVChargeDetail.createEVChargeDetail(evCharge15, 2023, "타기관", "LG유플러스", evChargeType21,false, 3)
            );
            for(EVChargeDetail evChargeDetail : evChargeDetailInfos){
                em.persist(evChargeDetail);
            }

            return evChargeDetailInfos;
        }
    }



}
