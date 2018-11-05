package com.bit.lib.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.notice.dao.NoticeInterfaceDao;
import com.bit.lib.notice.model.NoticeModel;

public class NoticeListService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	private NoticeInterfaceDao noticeInterfaceDao;

	public List<NoticeModel> noticeList(){
		

		noticeInterfaceDao=sessionTemplate.getMapper(NoticeInterfaceDao.class);//인터페이스를 실행가능한 객체로 만들어준다.
		
		List<NoticeModel>list =noticeInterfaceDao.selectnotice();
		
		return list;
		
		
	}
}
