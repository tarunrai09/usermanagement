package com.usermanagement.userdto;

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

	public Integer getSuppervisoruserId() {
		return SuppervisoruserId;
	}

	public void setSuppervisoruserId(Integer suppervisoruserId) {
		SuppervisoruserId = suppervisoruserId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getDeactivateUser() {
		return deactivateUser;
	}

	public void setDeactivateUser(String deactivateUser) {
		this.deactivateUser = deactivateUser;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHomeBranch() {
		return homeBranch;
	}

	public void setHomeBranch(String homeBranch) {
		this.homeBranch = homeBranch;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Double getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Double customerNo) {
		this.customerNo = customerNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserProfileDetailsDTO [SuppervisoruserId=" + SuppervisoruserId + ", loginId=" + loginId + ", shortName="
				+ shortName + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + ", entityId=" + entityId + ", emailId=" + emailId + ", deactivateUser="
				+ deactivateUser + ", department=" + department + ", homeBranch=" + homeBranch + ", userStatus="
				+ userStatus + ", customerNo=" + customerNo + ", userRole=" + userRole + ", password=" + password + "]";
	}

}
