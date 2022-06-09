package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_USER_TYPE")
@Data
public class UserType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_TYPE_ID")
	private Integer userTypeId;
	
	@Column(name = "USER_TYPE")
	private String userType;

	@Column(name = "IS_CBS_USER")
	private String userTypeBelongs;
	
	@Column(name="ROLE_TYPE")
	private String roleType;
	
	@Column(name = "USER_TYPE_TO_CREATE")
	private String userTypeToCreate;
	
	
}
