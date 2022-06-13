package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UserLoginResponse {
	
	
	private String isFirstLogin;
	
	private String status;
	
	private String status_msg;
	
	private String status_code;
	
	private UserDetailsResponse data;
	
	
}
