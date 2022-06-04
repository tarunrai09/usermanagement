package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.usermodel.RoleMaster;

public interface RoleRepository extends JpaRepository<RoleMaster, Integer>{
		
	Boolean existsByRoleType(String roleType);
	
	RoleMaster findByRoleType(String roleType);
	
}
