package com.usermanagement.usermodel;

import lombok.Data;

@Data
public class UserLoginRequest {
	
	private String loginId;
	
	private String password;
	
}
