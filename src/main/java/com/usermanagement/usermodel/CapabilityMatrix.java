package com.usermanagement.usermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "COM_IAM_CAPABILITY_MATRIX")
public class CapabilityMatrix {
     
	@Id
	@Column(name = "TELLER_TYPE")
	private Integer tellerType;
	
	@Column(name = "CAPABILITY")
	private Integer capability;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public Integer getTellerType() {
		return tellerType;
	}

	public void setTellerType(Integer tellerType) {
		this.tellerType = tellerType;
	}

	public Integer getCapability() {
		return capability;
	}

	public void setCapability(Integer capability) {
		this.capability = capability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CapabilityMatrix [tellerType=" + tellerType + ", capability=" + capability + ", description="
				+ description + "]";
	}
}
