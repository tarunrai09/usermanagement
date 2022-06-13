package com.usermanagement.userdto;

import lombok.Data;

@Data
public class RoleScreenRequest {
	
	String roleType;
	
	String userType;
	
	Integer userId;
	
	Integer roleTypeId;

}
