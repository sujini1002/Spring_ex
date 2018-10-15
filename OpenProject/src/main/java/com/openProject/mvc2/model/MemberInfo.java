package com.openProject.mvc2.model;

public class MemberInfo {
	//인스턴스변수 private처리 및 기본생성자 필히 작성
	private String userId;
	private String userPw;
	private String userName;
	private String userImg;
	
	public MemberInfo() {}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	@Override
	public String toString() {
		return "memberInfo [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userImg=" + userImg
				+ "]";
	}
	
}
