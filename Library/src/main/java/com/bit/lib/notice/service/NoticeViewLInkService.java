package com.bit.lib.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.notice.dao.NoticeInterfaceDao;
import com.bit.lib.notice.model.NoticeModel;

public class NoticeViewLInkService {


	@Autowired
	private SqlSessionTemplate sessionTemplate;

	private NoticeInterfaceDao noticeInterfaceDao;

	public NoticeModel noticeList(int bId) {
		System.out.println("service"+bId);
		noticeInterfaceDao = sessionTemplate.getMapper(NoticeInterfaceDao.class);// 인터페이스를 실행가능한 객체로 만들어준다.
		NoticeModel noticeModel = noticeInterfaceDao.selectviewLink(bId);
		System.out.println("모델"+noticeModel);
		return noticeModel;
	}
}
