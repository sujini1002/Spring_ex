package com.bit.lib.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.notice.dao.NoticeInterfaceDao;
import com.bit.lib.notice.model.NoticeModel;

public class NoticeDeleteService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private NoticeInterfaceDao noticeInterfaceDao;
	
	public void deleteLink(int bId) {
		
		noticeInterfaceDao = sessionTemplate.getMapper(NoticeInterfaceDao.class);// 인터페이스를 실행가능한 객체로 만들어준다.
		 noticeInterfaceDao.deleteLink(bId);
	}

}
