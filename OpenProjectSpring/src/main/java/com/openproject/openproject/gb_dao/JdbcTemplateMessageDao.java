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
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.openproject.openproject.gb_model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public int insertMessage(Message message) throws Exception {
		String sql = "insert into member_guest(userid,password,message) values(?,?,?)";
		
		int resultCnt = jdbcTemplate.update(sql,message.getUserId(), message.getPassword(), message.getMessage());
		return resultCnt;
	}
	/*KeyHolder keyholder = new GeneratedKeyHolder();
	int resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message.getUserId());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			return pstmt;
		}
	},keyholder);
	Number keyValue = keyholder.getKey();
	message.setMessageId(keyValue.intValue());
	return resultCnt;*/

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {

		String sql = "select * from member_guest limit ?,?";
		List<Message> messageList = jdbcTemplate.query(sql, new GuestMapper(), firstRow, endRow);
		return messageList;
	}

	public int selectCount() {

		String sql = "select count(*) from member_guest";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	@Transactional
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
