package com.example.evchargeproject.domain.controller.member;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@RequestMapping(value = "/member")
public class MemberController {
}
