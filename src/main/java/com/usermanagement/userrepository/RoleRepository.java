package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usermanagement.usermodel.RoleTypeDetails;

public interface RoleRepository extends JpaRepository<RoleTypeDetails, Integer>{
		
	
	Boolean existsByRoleType(String roleType);
	
	RoleTypeDetails findByRoleType(String roleType);
	
	RoleTypeDetails findByRoleId(Integer roleTypeId);
	
	@Query(nativeQuery = true, value = "SELECT MAX(role_type_id) FROM COM_IAM_ROLE_MASTER;")
	Integer getMaxRoleId();
}
