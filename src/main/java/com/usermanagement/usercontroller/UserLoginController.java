package com.usermanagement.usercontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.userdto.PasswordRequest;
import com.usermanagement.userdto.ResetPasswordRes;
import com.usermanagement.userdto.UserCreationRes;
import com.usermanagement.userdto.UserExistRes;
import com.usermanagement.userdto.UserLoginResponse;
import com.usermanagement.userdto.UserProfileDetailsDTO;
import com.usermanagement.usermodel.UserLoginRequest;
import com.usermanagement.usermodel.UserTypeRoleType;
import com.usermanagement.usermodel.UserSystemLogin;
import com.usermanagement.usermodel.ValidateEmailRequest;
import com.usermanagement.userservice.UserLoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(name = "/sbi/userLogin")
public class UserLoginController {

	@Autowired
	UserLoginService loginService;

	@PostMapping(value = "/userLoginDetails", consumes = "application/json", produces = "application/json")
	public UserLoginResponse userLogin(@RequestBody UserLoginRequest request) {

		return loginService.userLogin(request);
	}

	@PostMapping(value = "/resetPassword")
	public ResetPasswordRes resetPassword(@RequestBody PasswordRequest request) {
		return loginService.resetPasswordForFirstLogin(request);
	}

	@GetMapping(value = "/checkLoginIdExist/{loginId}")
	public UserExistRes checkUserExist(@PathVariable String loginId) {

		return loginService.checkLoginIdExist(loginId);
	}

	@GetMapping(value = "/getUserTypesByUserId/{userId}", consumes = "application/json", produces = "application/json")
	public List<UserTypeRoleType> getUserTypesByUserId(@PathVariable Integer userId) {

		return loginService.getUserTypesByUserId(userId);
	}

	@PostMapping(value = "/sendEmailForCreation", consumes = "application/json", produces = "application/json")
	public void sendEmail() {

		// loginService.sendEmail();
	}

	@PostMapping(value = "/validateEmailId", consumes = "application/json", produces = "application/json")
	public String validateEmailId(@RequestBody ValidateEmailRequest request) {

		return loginService.validateEmailId(request);
	}

	@PostMapping(value = "/validateSystemIP", consumes = "application/json", produces = "application/json")
	public String validateSystemIP(@RequestBody UserSystemLogin req) {

		return loginService.validateSystemIP(req);

	}

	@PostMapping(value = "/saveInternalUser", consumes = "application/json", produces = "application/json")
	public UserCreationRes saveInternalUser(@RequestBody UserProfileDetailsDTO request) {

		return loginService.saveUserDetails(request);

	}

	@PostMapping(value = "/saveExternalUser", consumes = "application/json", produces = "application/json")
	public UserCreationRes saveExternalUser(@RequestBody UserProfileDetailsDTO request) {

		return loginService.saveUserDetails(request);

	}

	@GetMapping(value = "/getUserPassword/{userId}", consumes = "application/json", produces = "application/json")
	public String getUserPassword(@PathVariable Integer userId) {

		return loginService.getUserPassword(userId);
	}

	@GetMapping(value = "/getUserIdByEnailId/{emailId}", consumes = "application/json", produces = "application/json")
	public Integer emailIdValidateUserId(@PathVariable @Valid String emailId) {
		return loginService.emailIdValidate(emailId);
	}

	@PostMapping(value = "/generateRandomPassword")
	public char[] generaterandomPassword() {
		return loginService.randomPasswordGenerator();
	}
}
