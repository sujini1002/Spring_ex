package com.openproject.openproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class JdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //컨텍션,close(),PrepareStatement 필요 없음
	
	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		int resultCnt = 0;
		String insert_sql = "insert into member_spring values(?,?,?,?)";
		
		resultCnt=jdbcTemplate.update(insert_sql,memberInfo.getUserId(),memberInfo.getUserPw(),
							memberInfo.getUserName(),memberInfo.getUserPhoto());
		return resultCnt;
	}


	public MemberInfo getMemberInfo(String id) throws SQLException {

		String sql = "select * from member_spring where userid = ?";
		
		List<MemberInfo> members = jdbcTemplate.query(sql, new MemberRowMapper(),id);

		return members.isEmpty()?null:members.get(0);
	}
	
	public List<MemberInfo> memberList(Connection conn) throws SQLException{
		
		List<MemberInfo> list = new ArrayList<>();
		
		String sql = "select * from member_spring";
		List<MemberInfo> members = jdbcTemplate.query(sql, new MemberRowMapper());
		
		return members;
		
	}


}