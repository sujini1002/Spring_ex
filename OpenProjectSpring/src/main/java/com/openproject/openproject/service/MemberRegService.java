package com.openproject.openproject.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openproject.openproject.dao.JdbcTemplateMemberDao;
import com.openproject.openproject.dao.MemberDao;
import com.openproject.openproject.jdbc.ConnectionProvider;
import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberRegService {
	//@Autowired
	//private MemberDao memberDao;
	
	@Autowired
	private JdbcTemplateMemberDao memberDao;
	
	
	
	public int memberReg(MemberInfo memberInfo,HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		
		
		int resultCnt = 0;
		
		
		
		//물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		//uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		System.out.println(dir);
		//DB저장용 파일이름,물리적 저장할 때의 이름
		String imgName = "";
		
		if(!memberInfo.getUserImg().isEmpty()) {
			imgName = memberInfo.getUserId()+"_"+memberInfo.getUserImg().getOriginalFilename();
			//물리적 저장
			memberInfo.getUserImg().transferTo(new File(dir, imgName));
			//DB에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName); 
		}
		System.out.println(memberInfo);
		resultCnt = memberDao.insertMemberInfo(memberInfo);
		 
		return resultCnt;
	}
}
