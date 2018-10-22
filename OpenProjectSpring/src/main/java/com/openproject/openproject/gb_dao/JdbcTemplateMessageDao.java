package com.openproject.openproject.gb_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openproject.openproject.gb_model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertMessage(Message message) throws Exception {
		String sql = "insert into member_guest values(msg_id.nextval,?,?,?)";
		int resultCnt = jdbcTemplate.update(sql, message.getUserId(), message.getPassword(), message.getMessage());
		return resultCnt;
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {

		String sql = "select messageid, userid, password, message from ( "
				+ " select rownum rnum, messageid, userid, password, message from ( "
				+ " select * from member_guest m order by m.messageid desc " + " ) where rownum <= ? "
				+ ") where rnum >= ?";
		List<Message> messageList = jdbcTemplate.query(sql, new GuestMapper(), endRow, firstRow);
		return messageList;
	}

	public int selectCount() {

		String sql = "select count(*) from member_guest";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public int delete(int messageId) {

		String sql = "delete from member_guest where messageid = ?";
		int resultCnt = jdbcTemplate.update(sql, messageId);

		return resultCnt;
	}

	public Message select(int messageId) {

		String sql = "select * from member_guest where messageid = ?";
		List<Message> results = jdbcTemplate.query(sql, new GuestMapper(),messageId);
		
		return results.isEmpty()?null:results.get(0);
	}

}
