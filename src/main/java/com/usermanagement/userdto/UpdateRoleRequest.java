package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UpdateRoleRequest {
		
	Integer userId;
	
	String userType;
	
	String newRoleType;
	
	String existingRoleType;
	
	String roleDescription;
	
}
