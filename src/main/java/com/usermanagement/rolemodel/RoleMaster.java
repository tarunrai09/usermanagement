package com.usermanagement.rolemodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "ROLE_DESCRIPTION")
@Data
public class RoleMaster {

	@Id
	@Column(name = "ROLE_ID")
	private Integer roleId;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	@Column(name = "ROLE_TYPE")
	private String roleType;

	
}
