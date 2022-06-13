package com.usermanagement.userdto;

import java.util.List;

import com.usermanagement.usermodel.UserType;

import lombok.Data;

@Data
public class RoleTypesResponse {
		
	private List<UserType> data;
	
	private String status;
	
	private String status_msg;
	
	private String status_code;
	
}
