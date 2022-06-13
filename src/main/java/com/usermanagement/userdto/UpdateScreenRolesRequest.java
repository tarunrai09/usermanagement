package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UpdateScreenRolesRequest {
	
	private Integer userId;
	
	private Integer roleTypeId;
	
	private String menuOrder;
	
	private Integer screenId;
	
	private String roleType;

	private Boolean isInternetChannel;
	
	private Boolean isMobileChannel;

	private Boolean deleteAccess;

	private Boolean viewAccess;
	
	private Boolean addAccess;
	
	private Boolean editAccess;
	
	private Boolean isAccessAllowed;

}
