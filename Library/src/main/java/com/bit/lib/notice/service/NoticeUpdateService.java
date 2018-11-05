package com.bit.lib.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.notice.dao.NoticeInterfaceDao;
import com.bit.lib.notice.model.NoticeModel;

public class NoticeUpdateService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	private NoticeInterfaceDao noticeInterfaceDao;

	public NoticeModel updateLink(int bId) {

		noticeInterfaceDao = sessionTemplate.getMapper(NoticeInterfaceDao.class);// 인터페이스를 실행가능한 객체로 만들어준다.

		return noticeInterfaceDao.selectviewLink(bId);

	}

	public void updateLink2(NoticeModel updateBoard2) {

		noticeInterfaceDao = sessionTemplate.getMapper(NoticeInterfaceDao.class);// 인터페이스를 실행가능한 객체로 만들어준다.

		noticeInterfaceDao.update(updateBoard2);
	}
}
