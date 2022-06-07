package com.usermanagement.usermodel;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COM_IAM_USER_SYSYTEM")
@Data
public class UserSystemDetails {

	
	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "SERVER_DATE_TIME")
	private LocalDateTime serverDateTime;

	@Column(name = "PFID")
	private Double pfId;

	@Column(name = "BRANCH_CODE")
	private String branchCode;

	@Column(name = "CC_ID")
	private String ccId;

	@Column(name = "CPC_BRANCH_CODE")
	private String cpcBranchCode;
	@Column(name = "BANK_CODE")
	private String bankCode;
	@Column(name = "CHANNEL")
	private String channel;
	@Column(name = "IP_OF_SERVER")
	private String ipOfServer;
	@Column(name = "IP_ADDRESS_DESKTOP")
	private String ipOfDesktop;
	
}
