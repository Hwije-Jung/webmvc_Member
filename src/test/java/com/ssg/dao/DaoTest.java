package com.ssg.dao;

import com.ssg.webmvc_member.dao.MemberDAO;
import com.ssg.webmvc_member.domain.MemberVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DaoTest {

    private MemberDAO memberDAO;

    @BeforeEach
    public void ready(){
        memberDAO = new MemberDAO();
    }


    @Test
    public void insertTest () throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .id("test")
                .pw("test")
                .name("testName")
                .email("testEmail")
                .date(LocalDate.of(2021,12,12))
                .build();
        memberDAO.addMember(memberVO);
    }

    @Test
    public void modifyTest() throws Exception{
        MemberVO memberVO = MemberVO.builder()
                .id("testid")
                .pw("modtest")
                .name("modtestName")
                .email("modtestEmail")
                .build();

        memberDAO.modifyMember(memberVO);
    }

    @Test
    public void delTest() throws Exception{
        MemberVO memberVO = MemberVO.builder()
                .id("ㅋㅋ")
                .build();

        memberDAO.delMember(memberVO);
    }
}
