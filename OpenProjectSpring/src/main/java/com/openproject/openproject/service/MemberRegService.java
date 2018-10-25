package com.openproject.openproject.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openproject.openproject.dao.MemberDaoInterface;
import com.openproject.openproject.dao.MybatisMemberDao;
import com.openproject.openproject.model.MemberInfo;

public class MemberRegService {
	//@Autowired
	//private MemberDao memberDao;
	
/*	@Autowired
	private JdbcTemplateMemberDao memberDao;*/
	
	/*@Autowired
	private MybatisMemberDao memberDao;*/
	
	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;
	
	private MemberDaoInterface memberDao; //인터페이스이므로 주입이 필요 없다
	
	@Transactional
	public int memberReg(MemberInfo memberInfo,HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		
		memberDao = SqlSessionTemplate.getMapper(MemberDaoInterface.class);
		
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
