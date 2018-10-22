package com.openproject.openproject.gb_dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.openproject.openproject.gb_model.Message;
import com.openproject.openproject.model.MemberInfo;

public class GuestMapper implements  RowMapper<Message> {
	@Override
	public Message mapRow(ResultSet rs,int rowNum) throws SQLException {
		Message message= new Message();
		message.setMessageId(rs.getInt("messageid"));
		message.setUserId(rs.getString("userid"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));

		return message;
	}

}
