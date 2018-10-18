package com.openproject.openproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberDao {

	public int insertMemberInfo(Connection conn, MemberInfo memberInfo) throws SQLException {
		//예외처리는 DAO에서 처리 하지 않고 service나 Controller에서 처리한다.
		PreparedStatement pstmt = null;
		
		int resultCnt = 0;
		
		String insert_sql = "insert into member_spring values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, memberInfo.getUserId());
			pstmt.setString(2, memberInfo.getUserPw());
			pstmt.setString(3, memberInfo.getUserName());
			pstmt.setString(4, memberInfo.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return resultCnt;
	
	}
	
}
