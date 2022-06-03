package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "")
public class UserDetails {

	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "PINCODE")
	private String pincode;
	@Column(name = "STATE")
	private String state;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "MOBILE_NO")
	private Double mobileNo;
	@Column(name = "ACCOUNT_NO")
	private String accountNO;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DATE_OF_BIRTH")
	private String dob;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "BRANCH_CODE")
	private String branchCode;
	@Column(name = "OCCUPATION")
	private String occupation;
	@Column(name = "EDUCATN_LEVEL")
	private String educationalLevel;

	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;

	@Column(name = "EMPLY_STATUS")
	private String emplyStatus;

	@Column(name = "PASSWORD_STATUS")
	private String passwordStatus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Double mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmplyStatus() {
		return emplyStatus;
	}

	public void setEmplyStatus(String emplyStatus) {
		this.emplyStatus = emplyStatus;
	}

	public String getPasswordStatus() {
		return passwordStatus;
	}

	public void setPasswordStatus(String passwordStatus) {
		this.passwordStatus = passwordStatus;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", address=" + address + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", accountNO=" + accountNO
				+ ", gender=" + gender + ", dob=" + dob + ", status=" + status + ", branchCode=" + branchCode
				+ ", occupation=" + occupation + ", educationalLevel=" + educationalLevel + ", maritalStatus="
				+ maritalStatus + ", emplyStatus=" + emplyStatus + ", passwordStatus=" + passwordStatus + "]";
	}
}
