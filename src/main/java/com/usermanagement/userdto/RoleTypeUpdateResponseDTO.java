package com.usermanagement.userdto;

import com.usermanagement.usermodel.UserTypeModel;

import lombok.Data;

@Data
public class RoleTypeUpdateResponseDTO {
	
	UserTypeModel userTypeModel;
	
	String message;
	
}
