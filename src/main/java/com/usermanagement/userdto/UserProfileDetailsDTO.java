package com.usermanagement.userdto;

import lombok.Data;

@Data
public class UserProfileDetailsDTO {

	private Integer SuppervisoruserId;

	private String loginId;

	private String shortName;

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNo;

	private String entityId;

	private String emailId;

	private String deactivateUser;

	private String department;

	private String homeBranch;

	private String userStatus;

	private Double customerNo;

	private String userRole;

	private String password;

}
