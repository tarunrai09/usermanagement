package com.usermanagement.userdto;

import lombok.Data;

@Data
public class PasswordRequest {
	
	private String loginId;
	
	private String password;
	
	private String confirmPassword;
	
}
