package com.usermanagement.userdto;

import lombok.Data;

@Data
public class SendRequest {

	private String emailId;
	private String loginId;
	private  String password;
}
