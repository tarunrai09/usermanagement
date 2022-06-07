package com.usermanagement.userrepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserLoginDetails;

@Repository
public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Integer> {

	UserLoginDetails findByUserId(Integer userId);
	
	UserLoginDetails findByLoginId(String loginId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="Update COM_IAM_USER_LOGIN_DETAILS  set IS_FIRST_LOGIN=:isFirstLogin , password=:password where login_Id=:loginId")
	void updateByLoginId(String loginId,String isFirstLogin,String password);
}
