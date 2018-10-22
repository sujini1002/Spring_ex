package com.openproject.openproject.gb_model;

//데이터 베이스에 있는 데이터를 받아서 처리
//사용자의 요청 데이터를 받아서 처리
public class Message {
	private int messageId;
	private String userId;
	private String password;
	private String message;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", userId=" + userId + ", password=" + password + ", message=" + message
				+ "]";
	}
	//비밀번호 일치 여부
	public boolean matchPassword(String pw) {
		return password.equals(pw); //비밀번호 값 만는 지 확인
	}
	public boolean hasPassword() {
		return password !=null && !password.isEmpty();
	}
	
}
//DAO역할 : 데이터 베이스 CRUD 기능
//DAO : 기능만 가진다. 싱글톤 처리(생성자 제한)