package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_ROLE_MASTER")
@Data
public class RoleTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_TYPE_ID")
	private Integer roleId;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	@Column(name = "ROLE_TYPE")
	private String roleType;

}
