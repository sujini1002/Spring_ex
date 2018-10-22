package com.openproject.openproject.gb_service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.openproject.gb_dao.JdbcTemplateMessageDao;
import com.openproject.openproject.gb_model.Message;
import com.openproject.openproject.jdbc.ConnectionProvider;
import com.openproject.openproject.jdbc.JdbcUtil;

public class GuestBookViewService {

	@Autowired
	private JdbcTemplateMessageDao jdbcTemplateMessageDao;

	public Message messageSelect(int id) {
		Message message = null;

		message = jdbcTemplateMessageDao.select(id);

		return message;
	}

}
