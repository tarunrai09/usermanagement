package com.usermanagement.usermodel;

public class ValidateEmailRequest {

	
	
	private String emailId;
	
	private Integer userId;
	
	private Integer mobileNo;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "ValidateEmailRequest [emailId=" + emailId + ", userId=" + userId + ", mobileNo=" + mobileNo + "]";
	}
}
