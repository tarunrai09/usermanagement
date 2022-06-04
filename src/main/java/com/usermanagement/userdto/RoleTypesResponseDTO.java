package com.usermanagement.userdto;

import java.util.List;

import com.usermanagement.usermodel.UserTypeModel;

import lombok.Data;

@Data
public class RoleTypesResponseDTO {
	
	List<UserTypeModel> userTypeModel;
	String message;
	
}
