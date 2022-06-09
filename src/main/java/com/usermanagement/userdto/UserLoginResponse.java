package com.usermanagement.userdto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserLoginResponse {
	
	
	private String isFirstLogin;
	
	private String status;
	
	private String status_msg;
	
	private String status_Code;
	
	private String userType;
	
	private String userName;
	
	private LocalDateTime updateTime; 
	
}
