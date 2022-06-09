package com.usermanagement.userdto;

import java.util.List;

import lombok.Data;

@Data
public class UserTypeResponse {

	
	private String status;
	
	private String status_Code;
	
	private String status_msg;
	
	private List<String> userTypes;
}
