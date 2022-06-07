package com.usermanagement.usermodel;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_USER_LOGIN_DETAILS")
@Data
public class UserLoginDetails {

	
	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CURRENT_STATUS")
	private String currentStatus;

	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "UPDATE_TIME")
	private LocalDateTime updateTime;

	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "ALLOW_PWD_CHNG")
	private String allowPasswordChange;

	@Column(name = "IS_FIRST_LOGIN")
	private String isFirstLogin;
}
