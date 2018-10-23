package com.openproject.openproject.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.model.MemberInfo;

public class MemberUpdateService {

	@Autowired
	private JdbcTemplateMemberDao jdbcTemplateMemberDao;

	// updateForm에 띄워줄 회원 정보
	public MemberInfo selectUser(String id) throws SQLException {

		MemberInfo member = jdbcTemplateMemberDao.getMemberInfo(id);
		return member;
	}

	// update수행해줄 메서드
	public int updateMember(MemberInfo memberInfo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		System.out.println(dir);
		// DB저장용 파일이름,물리적 저장할 때의 이름
		String imgName = "";

		if (!memberInfo.getUserImg().isEmpty()) {
			imgName = memberInfo.getUserId() + "_" + memberInfo.getUserImg().getOriginalFilename();
			// 물리적 저장
			memberInfo.getUserImg().transferTo(new File(dir, imgName));
			// DB에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);
		}

		int resultCnt = jdbcTemplateMemberDao.updateMember(memberInfo);

		return resultCnt;
	}
}
