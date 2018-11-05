package com.bit.lib.member.model;

public class MemberVO {

	private String member_id; // 회원 아이디
	private String password; // 회원 비밀번호
	private String name; // 회원 이름
	private int availAmount; // 대출 가능 권수
	private String phone; // 전화번호
	private int totborrowDays; // 총 대여일
	private int totoverduedays; // 총 연체일
	private String possibledate; // 대출 가능 일자

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailAmount() {
		return availAmount;
	}

	public void setAvailAmount(int availAmount) {
		this.availAmount = availAmount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTotborrowDays() {
		return totborrowDays;
	}

	public void setTotborrowDays(int totborrowDays) {
		this.totborrowDays = totborrowDays;
	}

	public int getTotoverduedays() {
		return totoverduedays;
	}

	public void setTotoverduedays(int totoverduedays) {
		this.totoverduedays = totoverduedays;
	}

	public String getPossibledate() {
		return possibledate;
	}

	public void setPossibledate(String possibledate) {
		this.possibledate = possibledate;
	}

	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", password=" + password + ", name=" + name + ", availAmount="
				+ availAmount + ", phone=" + phone + ", totborrowDays=" + totborrowDays + ", totoverduedays="
				+ totoverduedays + ", possibledate=" + possibledate + "]";
	}
}
