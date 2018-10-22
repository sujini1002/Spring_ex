package com.openproject.openproject.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.dao.MemberDao;
import com.openproject.openproject.jdbc.ConnectionProvider;
import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberListService {
	@Autowired
	private JdbcTemplateMemberDao memberDao;

	private Connection conn;

	public List<MemberInfo> memberSelect() throws SQLException {
		List<MemberInfo> list = null;

		try {
			conn = ConnectionProvider.getConnection();
			list = memberDao.memberList(conn);
			return list;
		} finally {
			JdbcUtil.close(conn);
		}
		

	}

}
