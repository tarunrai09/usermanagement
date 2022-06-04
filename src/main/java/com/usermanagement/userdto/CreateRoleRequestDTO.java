package com.usermanagement.userdto;

import lombok.Data;

@Data
public class CreateRoleRequestDTO {
	
	String userType;
	
	String roleDescription;
	
	String roleType;
	
	String isCbsUser;

}
