package com.usermanagement.userdto;

import java.util.List;

import com.usermanagement.usermodel.UserType;

import lombok.Data;

@Data
public class RoleTypesResponseDTO {
	
	List<UserType> userTypeModel;
	String message;
	
}
