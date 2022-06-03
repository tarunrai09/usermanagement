package com.usermanagement.rolemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "USER_ROLE_MAP")
@Data
public class UserRoleMap {

	@Id
	@Column(name = "USER_ID" )
	private Integer userId;
	
	@Column(name = "ROLE_ID")
	private  String roleId;

}
