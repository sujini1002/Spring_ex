package com.openproject.openproject.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.dao.MemberDao;
import com.openproject.openproject.jdbc.ConnectionProvider;
import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberLoginService {

	@Autowired
	private JdbcTemplateMemberDao memberDao;

	public boolean login(String id, String pw, HttpSession session) throws SQLException {

		boolean result = false;

		MemberInfo memberInfo = memberDao.getMemberInfo(id);

		// 사용자가 입력한 id의 존재 유뮤
		if (memberInfo != null && memberInfo.getUserPw().equals(pw)) {

			// 로그인 처리 : 세션에 사용자 데이터 저장
			memberInfo.setUserPw("");
			System.out.println(memberInfo);
			session.setAttribute("loginInfo", memberInfo);
			result = true;

		}

		return result;
	}
}
