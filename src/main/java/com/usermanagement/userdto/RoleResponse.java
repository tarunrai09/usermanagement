package com.usermanagement.userdto;

import com.usermanagement.usermodel.RoleTypeDetails;

import lombok.Data;

@Data
public class RoleResponse {	
	
	private RoleTypeDetails data;
	
	private String status;
	
	private String status_msg;
	
	private String status_code;

}
