package com.bit.lib.admin.model;

public class AdminVO {

	private String admin_id; // 관리자 아이디
	private String password; // 관리자 비밀번호
	private String permission; // 관리자 권한

	// 상세
	// 권한 관련하여 T/F 조합의 문자열로 저장
	// 1 T/F) 관리자 계정 권한 부여 기능
	// 2 T/F) 공지사항 게시판 접근 기능
	// 3 T/F) 도서 등록/삭제 기능
	// 4 T/F) 도서 대출 관련 기능
	// 5 T/F) 회원 등록/수정/삭제 기능
	
	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "AdminVO [admin_id=" + admin_id + ", password=" + password + ", permission=" + permission + "]";
	}

}
