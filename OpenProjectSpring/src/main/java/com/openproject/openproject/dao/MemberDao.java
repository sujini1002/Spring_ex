package com.openproject.openproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.openproject.openproject.jdbc.JdbcUtil;
import com.openproject.openproject.model.MemberInfo;

public class MemberDao {

	public int insertMemberInfo(Connection conn, MemberInfo memberInfo) throws SQLException {
		// 예외처리는 DAO에서 처리 하지 않고 service나 Controller에서 처리한다.
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

	public MemberInfo getMemberInfo(Connection conn, String id) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		String sql = "select * from member_spring where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setUserPw(rs.getString("userpw"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userimg"));
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return memberInfo;
	}
	
	public List<MemberInfo> memberList(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberInfo> list = new ArrayList<>();
		
		String sql = "select * from member_spring";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					list.add(this.makeMeberListResult(rs));
				}while(rs.next());
			}else {
				list = Collections.emptyList();
			}
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return list;
		
	}

	private MemberInfo makeMeberListResult(ResultSet rs) throws SQLException {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setUserId(rs.getString("userid"));
		memberInfo.setUserPw(rs.getString("userpw"));
		memberInfo.setUserName(rs.getString("username"));
		memberInfo.setUserPhoto(rs.getString("userimg"));
		System.out.println(memberInfo);
		return memberInfo;
	}


}
