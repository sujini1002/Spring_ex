package com.openproject.openproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.openproject.openproject.model.MemberInfo;

public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;
	private String mapperPath = "com.openproject.openproject.mapper.mybatis.MemberMapper";
	
	@Transactional
	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {
		
		return SqlSessionTemplate.update(mapperPath+".insertMember", memberInfo);
	}


	public MemberInfo getMemberInfo(String userid) throws SQLException {
		
		return  SqlSessionTemplate.selectOne(mapperPath+".selectById",userid);
	}
	
	public List<MemberInfo> memberList() throws SQLException{
		
		List<MemberInfo> list = new ArrayList<>();
		
		list = SqlSessionTemplate.selectList(mapperPath+".selectByList");
		return list;
		
	}
	/*
	@Transactional
	public int updateMember(MemberInfo memberInfo) {
		String sql  = "update member_spring set userpw = ? , username = ? ,userImg = ? where userid = ?";
		int resultCnt = SqlSessionTemplate.update(sql,memberInfo.getUserPw(),
											memberInfo.getUserName(),memberInfo.getUserPhoto(),memberInfo.getUserId());
		return resultCnt;
	}
	
	@Transactional
	public int deleteMember(String userId) {
		String sql = "delete from member_spring where userid = ?";
		int resultCnt = jdbcTemplate.update(sql, userId);
		return resultCnt;
	}*/


}
