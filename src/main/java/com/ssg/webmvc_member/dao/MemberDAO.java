package com.ssg.webmvc_member.dao;

import com.ssg.webmvc_member.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public List<MemberVO> listMembers() throws Exception{
        String sql = "select * from mvc_member";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = psmt.executeQuery();

        List<MemberVO> voList = new ArrayList<>();

        while (rs.next()){
            MemberVO memberVO = MemberVO.builder()
                    .id(rs.getString("id"))
                    .pw(rs.getString("pw"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .date(rs.getDate("date").toLocalDate())
                    .build();
            voList.add(memberVO);
        }

        return voList;
    }

    public void addMember(MemberVO memberVO) throws Exception {
        String sql = "insert into mvc_member (id, pw,name,email,date) values ( ?,?,?,?,now())";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1,memberVO.getId());
        psmt.setString(2,memberVO.getPw());
        psmt.setString(3,memberVO.getName());
        psmt.setString(4,memberVO.getEmail());

        psmt.executeUpdate();
    }

    public void modifyMember(MemberVO memberVO) throws Exception{
        String sql = "update mvc_member set pw = ?, name = ?, email = ? where id = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1,memberVO.getPw());
        psmt.setString(2,memberVO.getName());
        psmt.setString(3,memberVO.getPw());
        psmt.setString(4,memberVO.getId());

        psmt.executeUpdate();


    }

    public void delMember(MemberVO memberVO) throws Exception{

        String sql = "delete from mvc_member where id = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1,memberVO.getId());

        psmt.executeUpdate();
    }
}
