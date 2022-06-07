package com.usermanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.usermodel.UserSystemDetails;


@Repository
public interface UserSystemRepository extends JpaRepository<UserSystemDetails, Integer>{

	
}
