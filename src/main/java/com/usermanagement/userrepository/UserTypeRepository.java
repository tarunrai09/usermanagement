package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserType;

import java.util.List;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, String> {

	
	List<UserType> findByUserType(String userType);
	
	List<UserType> findByUserTypeBelongs(String userTypeBelongs);
	
	@Query(nativeQuery = true, value = "SELECT MAX(USER_TYPE_ID) FROM COM_IAM_USER_TYPE;")
	Integer getMaxUserTypeId();
			
}
