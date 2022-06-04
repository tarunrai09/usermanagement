package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserTypeModel;

import java.util.List;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeModel, String> {

	List<UserTypeModel> findByUserType(String userType);
	
	List<UserTypeModel> findByUserTypeBelongs(String userTypeBelongs);
			
}
