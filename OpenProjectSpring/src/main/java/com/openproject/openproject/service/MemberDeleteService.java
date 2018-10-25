package com.openproject.openproject.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.dao.MemberDaoInterface;
import com.openproject.openproject.model.MemberInfo;

public class MemberDeleteService {
	
	/*@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;*/
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDaoInterface memberDao;
	
	@Transactional
	public int deleteMember(String id,String pw) throws SQLException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		int resultCnt = 0;
		MemberInfo member = memberDao.getMemberInfo(id);
		if(pw.equals(member.getUserPw())) {
			resultCnt= memberDao.deleteMember(id);
		}
		return resultCnt;
	}
	
}
