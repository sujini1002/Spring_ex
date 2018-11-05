package com.bit.lib.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;

@Service
public class MemberLoginService {

	@Autowired
	MemberDao memberDao;

	// 관리자 로그인
	public boolean memberLogin(String member_id, String password, HttpSession session) {
		boolean result = memberDao.matchPassword(member_id, password);
		// 로그인 성공시
		if (result) {
			// 세션에 관리자 로그인 세션 저장
			MemberVO memberVO = memberDao.selectOneMember(member_id);
			memberVO.setPassword(""); // 보안을 위해 비밀번호 공백 처리
			session.setAttribute("memberLoginInfo", memberVO);
		}
		return result;
	}
}
