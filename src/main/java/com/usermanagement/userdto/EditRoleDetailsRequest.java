package com.usermanagement.userdto;

import lombok.Data;

@Data
public class EditRoleDetailsRequest {
	
	private Integer roleTypeId;
		
	private String roleDescription;
	
	private String roleType;

	private String userRoleType;
}

