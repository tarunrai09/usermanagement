package com.usermanagement.userdto;

import com.usermanagement.usermodel.UserType;

import lombok.Data;

@Data
public class RoleTypeUpdateResponseDTO {
	
	
	UserType userTypeModel;
	
	String message;
	
}
