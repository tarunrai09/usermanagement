package com.usermanagement.userdto;

import java.util.List;

public class RoleTypesResponseDTO {
	String userId;
	List<String> roles;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
