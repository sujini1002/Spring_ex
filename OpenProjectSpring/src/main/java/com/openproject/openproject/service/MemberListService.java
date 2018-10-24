package com.openproject.openproject.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.dao.MemberDao;
import com.openproject.openproject.dao.MemberDaoInterface;
import com.openproject.openproject.dao.MybatisMemberDao;
import com.openproject.openproject.jdbc.ConnectionProvider;
import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberListService {
	/*
	 * @Autowired private MybatisMemberDao memberDao;
	 */

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private MemberDaoInterface memberDao;

	public List<MemberInfo> memberSelect() throws SQLException {
		
		memberDao = sqlSessionTemplate.getMapper(MemberDaoInterface.class);
		List<MemberInfo> list = null;

		list = memberDao.selectByList();
		return list;
	}

}
