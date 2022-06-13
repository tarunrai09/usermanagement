package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.RoleScreenMap;
import com.usermanagement.usermodel.UserIdRoleId;

@Repository
public interface RoleScreenMapRepository extends JpaRepository<RoleScreenMap, UserIdRoleId>{
	
}
