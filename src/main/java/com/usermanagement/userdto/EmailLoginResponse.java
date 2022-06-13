package com.usermanagement.userdto;

import lombok.Data;

@Data
public class EmailLoginResponse {

	private String loginId;
	
	private String status;
	
	private String status_code;
	
	private String status_msg;
}
