package com.openproject.openproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openproject.openproject.model.MemberInfo;

public class MemberRowMapper implements RowMapper<MemberInfo>{
	@Override
	public MemberInfo mapRow(ResultSet rs,int rowNum) throws SQLException {
		MemberInfo member= new MemberInfo();
		member.setUserId(rs.getString("userid"));
		member.setUserPw(rs.getString("userpw"));
		member.setUserName(rs.getString("username"));
		member.setUserPhoto(rs.getString("userimg"));
		return member;
	}
}
