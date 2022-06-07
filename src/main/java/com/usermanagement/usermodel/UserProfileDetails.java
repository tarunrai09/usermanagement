package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_USER_PROFILE")
@Data
public class UserProfileDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "SHORT_NAME")
	private String shortName;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "LOGIN_ID")
	private String loginId;
	@Column(name = "ENTITY_ID")
	private String entityId;
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "DEPARTMENT")
	private String department;
	@Column(name = "BRANCH_CODE")
	private String homeBranch;
	@Column(name = "USER_STATUS")
	private String userStatus;
	@Column(name = "CUSTOMER_NO")
	private Double customerNo;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "USER_PASSWORD")
	private char[] password;

}
