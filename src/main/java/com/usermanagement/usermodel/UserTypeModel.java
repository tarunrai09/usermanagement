package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "USER_TYPE")
@Data
public class UserTypeModel {

	@Id
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "USER_DESCRIPTION")
	private String userDescription;

	@Column(name = "USER_TYPE_BELONGS")
	private String userTypeBelongs;
	
	
}
