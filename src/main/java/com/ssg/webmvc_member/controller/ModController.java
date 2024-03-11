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

@WebServlet("/modMember.do")
@Log4j2
public class ModController extends HttpServlet {

    MemberService memberService = MemberService.INSTANCE;

    protected void doGet (HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException{

        String id = req.getParameter("id");
        System.out.println(id);
        req.setAttribute("id",id);
        req.getRequestDispatcher("/WEB-INF/member/modMember.jsp").forward(req,resp);

    }

    protected void doPost (HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException{
        MemberDTO memberDTO = MemberDTO.builder()
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .build();

        System.out.println(memberDTO);

        try {
            memberService.modifyMember(memberDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/mem.do");

    }

}
