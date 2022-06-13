package com.usermanagement.userdto;

import lombok.Data;

@Data
public class EmailIdResponse {

	private String status_code;
	
	private String status;
	
	private String status_msg;
	
    private String isExist;
    
}
