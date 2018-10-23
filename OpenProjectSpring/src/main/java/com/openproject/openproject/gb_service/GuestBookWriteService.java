package com.openproject.openproject.gb_service;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.gb_dao.JdbcTemplateMessageDao;
import com.openproject.openproject.gb_model.Message;

public class GuestBookWriteService {
	
	@Autowired
	private JdbcTemplateMessageDao jdbcTemplateMessageDao;
	
	public int insert(Message message) throws Exception {
		int resultCnt = 0;
		resultCnt = jdbcTemplateMessageDao.insertMessage(message);
		System.out.println("messageId : "+message.getMessageId());
		return resultCnt;
	}
}
