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

@WebServlet("/addMember.do")
@Log4j2
public class AddMemberController extends HttpServlet {

    MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println("컨트롤러까지옴");
        req.getRequestDispatcher("/WEB-INF/member/addMember.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        MemberDTO memberDTO = MemberDTO.builder()
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .build();

        try {
            memberService.addMember(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/mem.do");

    }
}
