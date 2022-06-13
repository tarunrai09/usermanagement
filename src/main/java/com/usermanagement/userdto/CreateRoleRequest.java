package com.usermanagement.userdto;

import lombok.Data;

@Data
public class CreateRoleRequest {
	
	Integer userId;
	
	String userType;
	
	String roleDescription;
	
	String roleType;
	
	String userRoleType;
	
	String isCbsUser;

}
