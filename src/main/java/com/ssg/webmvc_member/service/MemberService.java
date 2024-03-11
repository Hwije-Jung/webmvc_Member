package com.ssg.webmvc_member.service;

import com.ssg.webmvc_member.dao.MemberDAO;
import com.ssg.webmvc_member.domain.MemberVO;
import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;
    private MemberDAO dao;
    private ModelMapper modelMapper;
    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<MemberDTO> listMembers() throws Exception {
        List<MemberVO> voList = dao.listMembers();
        List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class)).collect(Collectors.toList());

        return dtoList;

    }

    public void addMember(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(memberDTO,MemberVO.class);
        dao.addMember(memberVO);
    }

    public void modifyMember(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        dao.modifyMember(memberVO);
    }

    public void delMember(MemberDTO memberDTO) throws Exception{
        MemberVO memberVO = modelMapper.map(memberDTO,MemberVO.class);
        dao.delMember(memberVO);
    }


}
