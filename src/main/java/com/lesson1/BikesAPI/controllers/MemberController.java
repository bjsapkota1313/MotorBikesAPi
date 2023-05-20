package com.lesson1.BikesAPI.controllers;

import com.lesson1.BikesAPI.model.DTO.LoginRequestDTO;
import com.lesson1.BikesAPI.model.DTO.ResponseTokenDTO;
import com.lesson1.BikesAPI.services.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/login")
    public Object login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        return new ResponseTokenDTO(memberService.login(loginRequestDTO));
    }

}
