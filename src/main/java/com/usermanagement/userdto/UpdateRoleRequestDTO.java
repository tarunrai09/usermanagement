package com.usermanagement.userdto;

public class UpdateRoleRequestDTO {
	String userId;
	String roleType;
	String roleDescription;
	
	public String getUserId() {
		return userId;
	}	
	public String getRoleType() {
		return roleType;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
}
