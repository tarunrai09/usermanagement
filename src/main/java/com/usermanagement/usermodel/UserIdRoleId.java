package com.usermanagement.usermodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UserIdRoleId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "USER_ID")	
	private Integer userId;
	
	@Column(name = "ROLE_TYPE_ID")	
	private Integer roleTypeId;

}
