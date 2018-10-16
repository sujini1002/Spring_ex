package com.bitcamp.mvc1016;

public class Address {
	
	private String zipCode;
	private String address1;
	private String address2;
	
	
	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", address1=" + address1 + ", address2=" + address2 + "]";
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
}
