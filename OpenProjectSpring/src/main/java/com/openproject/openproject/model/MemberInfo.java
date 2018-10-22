package com.openproject.openproject.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {
	// 인스턴스변수 private처리 및 기본생성자 필히 작성
	private String userId;
	private String userPw;
	private String userName;
	private String userPhoto; // DB에 저장할 파일 이름
	private MultipartFile userImg;

	public MemberInfo() {
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public MultipartFile getUserImg() {
		return userImg;
	}

	public void setUserImg(MultipartFile userImg) {
		this.userImg = userImg;
	}

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

	@Override
	public String toString() {
		return "MemberInfo [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhoto="
				+ userPhoto + "]";
	}

}
