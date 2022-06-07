package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.usermodel.RoleTypeDetails;

public interface RoleRepository extends JpaRepository<RoleTypeDetails, Integer>{
		
	Boolean existsByRoleType(String roleType);
	
	RoleTypeDetails findByRoleType(String roleType);
	
}
