package com.usermanagement.userdto;

import java.util.List;

import com.usermanagement.usermodel.RoleTypeDetails;

import lombok.Data;

@Data
public class RoleDetailsListResponse {
	
	private List<RoleTypeDetails> data;
	
	private String status;
	
	private String status_msg;
	
	private String status_code;
	

}
