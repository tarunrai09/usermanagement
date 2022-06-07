package com.usermanagement.usermodel;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_USER_TYPE_ROLE_TYPE_MAP")
@Data
public class UserTypeRoleType {
	
	private String roleType;
	
	private String userType;
	
	@Id
	private Integer userId;
	
}
