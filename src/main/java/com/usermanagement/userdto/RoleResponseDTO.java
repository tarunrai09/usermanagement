package com.usermanagement.userdto;

public class RoleResponseDTO {
	String responseMessage;
	int statusCode;

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
