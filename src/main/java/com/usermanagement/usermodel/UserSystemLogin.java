package com.usermanagement.usermodel;

public class UserSystemLogin {

	
	private Integer userId;
	
	private String ipAddress;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "UserSystemLogin [userId=" + userId + ", ipAddress=" + ipAddress + "]";
	}
}
