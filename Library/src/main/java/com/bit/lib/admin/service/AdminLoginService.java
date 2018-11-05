package com.bit.lib.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;
import com.bit.lib.admin.model.AdminVO;

@Service
public class AdminLoginService {

	@Autowired
	AdminDao adminDao;

//	public List<AdminVO> getAllAdmin() {
//		return adminDao.selectAllAdmin();
//	}

	// 관리자 로그인 화면에 관리자 아이디 목록을 출력
	public List<String> getAllAdminId() {
		return adminDao.selectAllAdminId();
	}

	// 관리자 로그인
	public boolean adminLogin(String admin_id, String password, HttpSession session) {
// 동적 시작
		// boolean result = adminDao.matchPassword(admin_id, password);
//		// 로그인 성공시
//		if (result) {
//			// 세션에 관리자 로그인 세션 저장
//			AdminVO adminVO = adminDao.selectOneAdmin(admin_id);
//			adminVO.setPassword(""); // 보안을 위해 비밀번호 공백 처리
//			session.setAttribute("adminLoginInfo", adminVO);
//		}
//		return result;
		// 동적 끝

		AdminVO av = new AdminVO();
		av.setAdmin_id(admin_id);
		boolean result = adminDao.matchPassword(av, password);

		if (result) {
			// 세션에 관리자 로그인 세션 저장
			av = adminDao.selectAdmin(av).get(0);
			av.setPassword(""); // 보안을 위해 비밀번호 공백 처리
			session.setAttribute("adminLoginInfo", av);
		}
		
		return result;
	}
}
