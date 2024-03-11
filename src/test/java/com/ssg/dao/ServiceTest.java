package com.ssg.dao;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    private MemberService memberService;

    @BeforeEach
    public void ready(){
        memberService = MemberService.INSTANCE;
    }

    @Test
    public void addMemberTest() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .id("testid")
                .pw("testpw")
                .name("testName")
                .email("testEmail")
                .build();

        memberService.addMember(memberDTO);
    }

    @Test
    public void modifyTest() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .id("testid")
                .pw("modiservice")
                .name("modiservice")
                .email("modiservice")
                .build();

        memberService.modifyMember(memberDTO);
    }

    @Test
    public void delTest() throws Exception{
        MemberDTO memberDTO = MemberDTO.builder()
                .id("asdafaa")
                .build();

        memberService.delMember(memberDTO);
    }



}
