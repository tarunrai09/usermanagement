package com.usermanagement.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.usermodel.UserTypeModel;
import com.usermanagement.userservice.UserTypeService;

@RestController
@RequestMapping(value="/sbi/userType")
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;

	@CrossOrigin(origins="*")
	@PostMapping(name = "/saveUserType", consumes = "application/json", produces = "application/json")
	public void saveUserType(@RequestBody UserTypeModel request) {

		userTypeService.saveSUerType(request);
	}

	@GetMapping(name = "/getUserType/{userType}", consumes = "application/json", produces = "application/json")
	public List<UserTypeModel> saveUserType(@PathVariable String userType) {

		return userTypeService.getUserTypeBasedOnUserBelongs(userType);

	}
}
