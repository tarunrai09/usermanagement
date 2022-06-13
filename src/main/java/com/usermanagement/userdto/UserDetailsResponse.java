package com.usermanagement.userdto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDetailsResponse {

	private String userType;
	
	private String roleType;
	
	private String loginId;
	
	private LocalDateTime updateTime; 
	
	private Integer userId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
}
