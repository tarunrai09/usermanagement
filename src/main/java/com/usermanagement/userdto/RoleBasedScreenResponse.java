package com.usermanagement.userdto;

import java.util.List;

import com.usermanagement.usermodel.RoleScreenMap;
import lombok.Data;

@Data
public class RoleBasedScreenResponse {
	
	private List<RoleScreenMap> data;
	
	private String status;
	
	private String status_msg;
	
	private String status_code;
}
