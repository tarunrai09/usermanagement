package com.usermanagement.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.usermodel.UserTypeModel;
import com.usermanagement.userrepository.UserTypeRepository;


@Service
public class UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	public void saveSUerType(UserTypeModel request) {

		userTypeRepository.save(request);
	}

	public List<UserTypeModel> getUserType(String userType) {
		return userTypeRepository.findByUserType(userType);
	}

	public List<UserTypeModel> getUserTypeBasedOnUserBelongs(String userType) {

		if (userType.equalsIgnoreCase("Admin")) {
			return userTypeRepository.findByUserTypeBelongs("Internal");

		}
		return null;
	}
}
