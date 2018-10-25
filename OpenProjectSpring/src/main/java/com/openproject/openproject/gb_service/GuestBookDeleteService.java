package com.openproject.openproject.gb_service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.gb_dao.JdbcTemplateMessageDao;
import com.openproject.openproject.gb_model.Message;

public class GuestBookDeleteService {
	
	@Autowired
	private JdbcTemplateMessageDao jdbcTemplateMessageDao;
	
	public void deleteMessage(int messageId,String password)
			throws ServiceException, InvalidMessagePassowrdException, MessageNotFoundException {
			
		Message message = jdbcTemplateMessageDao.select(messageId);
		
			if (message == null) {
				throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
			}
			if (!message.hasPassword()) {
				throw new InvalidMessagePassowrdException();
			}
			if (!message.getPassword().equals(password)) {
				throw new InvalidMessagePassowrdException();
			}
			jdbcTemplateMessageDao.delete(messageId);
		
	}
	
}
