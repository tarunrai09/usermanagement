package com.usermanagement.userdto;

public class RoleTypeUpdateResponseDTO {
	String userId;
	String roleType;
	String roleDescription;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
