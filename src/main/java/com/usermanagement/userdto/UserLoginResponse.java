package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UserLoginResponse {
	
	private String isFirstLogin;
	
	private String status;
	
	private String errorDesc;
}
