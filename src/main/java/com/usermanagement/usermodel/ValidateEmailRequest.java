package com.usermanagement.usermodel;

import lombok.Data;

@Data
public class ValidateEmailRequest {

	private String emailId;

	private Integer userId;

	private Integer mobileNo;
	
}
