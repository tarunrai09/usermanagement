package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UserCreationRes {

	private String status;
	private String errorDesc;
	private String message;
}
