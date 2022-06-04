package com.usermanagement.userrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserRoleMap;

@Repository
public interface UserTypeRoleTypeMapRepository extends JpaRepository<UserRoleMap, Integer> {

	List<UserRoleMap>  findByUserType(String userType);
	
	List<Integer> findByUserId(Integer userId);

}
