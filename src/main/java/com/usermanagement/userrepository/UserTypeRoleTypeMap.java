package com.usermanagement.userrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserTypeRoleType;

@Repository
public interface UserTypeRoleTypeMap extends JpaRepository<UserTypeRoleType, Integer> {

	
	List<UserTypeRoleType>  findByUserType(String userType);
	
	List<Integer> findByUserId(Integer userId);

}
