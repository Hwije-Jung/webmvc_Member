package com.ssg.webmvc_member.controller;


import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delMember.do")
@Log4j2
public class DelMemberController extends HttpServlet {

    MemberService memberService = MemberService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");

        MemberDTO memberDTO = MemberDTO.builder()
                .id(id)
                .build();

        try {
            memberService.delMember(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/mem.do");


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


    }
}
