package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserProfileDetails;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileDetails, Integer> {

	/*
	 * @Modifying
	 * 
	 * @Query(value =
	 * "update USER_PROFILE_DETAILS u set USER_STATUS=:inActive where u.USER_ID=:userId "
	 * , nativeQuery = true) void updatePassword(@Param("inActive") String
	 * inActive, @Param("userId") Integer userId);
	 */
	UserProfileDetails findByEmailId(String emailId);

	UserProfileDetails findByMobileNo(String mobileNo);
	
	UserProfileDetails findByUserId(Integer userId);

}
