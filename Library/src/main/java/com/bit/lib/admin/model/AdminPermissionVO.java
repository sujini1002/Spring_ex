package com.bit.lib.admin.model;

public class AdminPermissionVO {

	private int permissionCode; // 권한 코드
	private String permissionDetail; // 권한 코드에 대한 상세 설명

	public int getPermission() {
		return permissionCode;
	}

	public void setPermission(int permission) {
		this.permissionCode = permission;
	}

	public String getPermissionDetail() {
		return permissionDetail;
	}

	public void setPermissionDetail(String permissionDetail) {
		this.permissionDetail = permissionDetail;
	}

	@Override
	public String toString() {
		return "AdminPermissionVO [permissionKey=" + permissionCode + ", permissionDetail=" + permissionDetail + "]";
	}

}
