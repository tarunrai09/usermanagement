package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.rolemodel.RoleMaster;


public interface RoleRepository extends JpaRepository<RoleMaster, Integer>{
	String findByRoleId(Integer roleId);
}
