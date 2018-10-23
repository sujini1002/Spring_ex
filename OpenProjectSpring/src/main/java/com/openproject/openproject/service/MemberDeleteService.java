package com.openproject.openproject.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.model.MemberInfo;

public class MemberDeleteService {
	
	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;
	
	public int deleteMember(String id,String pw) throws SQLException {
		
		int resultCnt = 0;
		MemberInfo member = jdbcTemplateMemberDao.getMemberInfo(id);
		if(pw.equals(member.getUserPw())) {
			resultCnt= jdbcTemplateMemberDao.deleteMember(id);
		}
		return resultCnt;
	}
	
}
