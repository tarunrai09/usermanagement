package com.usermanagement.usermodel;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity(name = "COM_IAM_ROLE_SCREEN_MAP")
public class RoleScreenMap implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserIdRoleId id;
	
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