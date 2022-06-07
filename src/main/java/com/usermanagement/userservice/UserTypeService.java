package com.usermanagement.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.usermodel.UserType;
import com.usermanagement.userrepository.UserTypeRepository;


@Service
public class UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	public void saveSUerType(UserType request) {

		userTypeRepository.save(request);
	}

	public List<UserType> getUserType(String userType) {
		return userTypeRepository.findByUserType(userType);
	}

	public List<UserType> getUserTypeBasedOnUserBelongs(String userType) {

		if (userType.equalsIgnoreCase("Admin")) {
			return userTypeRepository.findByUserTypeBelongs("Internal");

		}
		return null;
	}
}
