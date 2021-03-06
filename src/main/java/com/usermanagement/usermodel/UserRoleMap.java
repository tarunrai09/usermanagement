package com.usermanagement.usermodel;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "USER_ROLE_TYPE_MAP")
@Data
public class UserRoleMap {

	private String roleType;

	
	private String userType;

	@Id
	private Integer userTypeId;
	
}
