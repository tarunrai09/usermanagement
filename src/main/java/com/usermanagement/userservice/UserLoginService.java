package com.usermanagement.userservice;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.usermanagement.userdto.PasswordRequest;
import com.usermanagement.userdto.ResetPasswordRes;
import com.usermanagement.userdto.UserCreationRes;
import com.usermanagement.userdto.UserExistRes;
import com.usermanagement.userdto.UserLoginResponse;
import com.usermanagement.userdto.UserProfileDetailsDTO;
import com.usermanagement.usermodel.UserLoginDetails;
import com.usermanagement.usermodel.UserLoginRequest;
import com.usermanagement.usermodel.UserProfileDetails;
import com.usermanagement.usermodel.UserSystemDetails;
import com.usermanagement.usermodel.UserSystemLogin;
import com.usermanagement.usermodel.UserTypeRoleType;
import com.usermanagement.usermodel.ValidateEmailRequest;
import com.usermanagement.userrepository.UserLoginDetailsRepository;
import com.usermanagement.userrepository.UserProfileRepository;
import com.usermanagement.userrepository.UserSystemRepository;
import com.usermanagement.userrepository.UserTypeRoleTypeMapRepository;

@Service
public class UserLoginService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	UserSystemRepository userSystemRepository;

	@Autowired
	UserLoginDetailsRepository userLoginDetails;

	@Autowired
	UserTypeRoleTypeMapRepository roleTypeMapRepository;

	@Autowired
	UserTypeRoleTypeMapRepository userTypeRoleTypeMapRepository;

	public static Cipher cipher;

	@Value("${spring.mail.username}")
	String userName;

	public List<UserTypeRoleType> getUserTypesByUserId(Integer userId) {

		UserProfileDetails res = userProfileRepository.findByUserId(userId);

		List<UserTypeRoleType> res1 = roleTypeMapRepository.findByUserType(res.getEntityId());

		return res1;
	}

	public UserLoginResponse userLogin(UserLoginRequest request) {

		UserLoginResponse response = new UserLoginResponse();

		UserLoginDetails res = userLoginDetails.findByLoginId(request.getLoginId());

		if (!ObjectUtils.isEmpty(res)) {
			if (!res.getIsFirstLogin().equalsIgnoreCase("Y")) {
				if (request.getPassword().equals(res.getPassword())) {

					response.setStatus("Success");
					response.setIsFirstLogin("N");
					return response;
				} else {

					response.setErrorDesc("Password entered is incorrect");
					response.setStatus("Failure");
					return response;
				}
			} else {
				if (request.getPassword().equals(res.getPassword())) {
					response.setIsFirstLogin("Y");
					response.setStatus("Success");
					return response;
				} else {
					response.setErrorDesc("Password entered is incorrect");
					response.setStatus("Failure");
					return response;
				}
			}

		} else {

			response.setErrorDesc("UserId does not exist in SCF.");
			response.setStatus("Failure");
			return response;
		}

	}

	public ResetPasswordRes resetPasswordForFirstLogin(PasswordRequest request) {

		ResetPasswordRes res = new ResetPasswordRes();
		userLoginDetails.updateByLoginId(request.getLoginId(), "N", request.getPassword());

		res.setStatus("Status");
		return res;

	}

	public String validateEmailId(ValidateEmailRequest req) {

		UserProfileDetails res = userProfileRepository.findById(req.getUserId()).get();
		if (!ObjectUtils.isEmpty(res)) {
			if (req.getEmailId().equalsIgnoreCase(res.getEmailId())) {

				return "Success";
			} else {
				return "Failure";
			}
		}
		return "Failure";

	}

	public String validateSystemIP(UserSystemLogin req) {

		UserSystemDetails res = userSystemRepository.findById(req.getUserId()).orElse(null);

		if (req.getIpAddress().equalsIgnoreCase(res.getIpOfDesktop())) {

			return "Success";
		} else {
			return "Failure";
		}
	}

	public String getUserPassword(Integer userId) {

		UserLoginDetails res = userLoginDetails.findById(userId).orElse(null);
		return "";
		// return new String(Base64.getDecoder().decode(res.getPassword()));
	}

	public UserCreationRes saveUserDetails(UserProfileDetailsDTO request) {

		UserCreationRes response1 = new UserCreationRes();
		/*
		 * To be done :- SYNC CBS to SCF Data UserSystem class needs to be filled after
		 * calling cbs
		 */
		UserProfileDetails res = userProfileRepository.findByEmailId(request.getEmailId());
		UserProfileDetails mobileRes = userProfileRepository.findByMobileNo(request.getMobileNo());
		if (ObjectUtils.isEmpty(res) && ObjectUtils.isEmpty(mobileRes)) {
			// if (request.getEmailId().equals(res.getEmailId()) &&
			// request.getMobileNo().equals(res.getMobileNo())) {
			UserProfileDetails profileReq = new UserProfileDetails();

			char[] password = this.randomPasswordGenerator();
			profileReq.setCustomerNo(request.getCustomerNo());
			profileReq.setDepartment(request.getDepartment());
			profileReq.setEmailId(request.getEmailId());
			profileReq.setHomeBranch(request.getHomeBranch());
			profileReq.setMobileNo(request.getMobileNo());
			profileReq.setLoginId(request.getLoginId());
			profileReq.setShortName(request.getShortName());
			profileReq.setFirstName(request.getFirstName());
			profileReq.setMiddleName(request.getMiddleName());
			profileReq.setLastName(request.getLastName());
			profileReq.setEntityId(request.getEntityId());
			profileReq.setPassword(password);
			if (!request.getDeactivateUser().equalsIgnoreCase("Y")) {
				profileReq.setUserStatus("Active");
			} else {
				profileReq.setUserStatus("InActive");
			}
			profileReq.setUserRole(request.getUserRole());
			UserProfileDetails profileRes = userProfileRepository.save(profileReq);

			UserLoginDetails loginReq = new UserLoginDetails();
			loginReq.setUserId(profileRes.getUserId());
			loginReq.setLoginId(profileRes.getLoginId());
			loginReq.setPassword(new String(profileRes.getPassword()));
			loginReq.setAllowPasswordChange("Y");
			loginReq.setCurrentStatus(profileRes.getUserStatus());
			loginReq.setUpdateTime(LocalDateTime.now());
			loginReq.setIsFirstLogin("Y");
			userLoginDetails.save(loginReq);

			UserProfileDetails userProfileDetails = userProfileRepository.findByLoginId(request.getLoginId());
			UserTypeRoleType userTypeRoleType = new UserTypeRoleType();
			userTypeRoleType.setRoleType(userProfileDetails.getUserRole());
			userTypeRoleType.setUserType(userProfileDetails.getEntityId());
			userTypeRoleType.setUserId(userProfileDetails.getUserId());
			userTypeRoleTypeMapRepository.save(userTypeRoleType);

			try {
				sendEmail(profileRes.getEmailId(), profileRes.getLoginId(), new String(profileRes.getPassword()));
			} catch (Exception e) {

				userProfileRepository.deleteById(profileRes.getUserId());

				userLoginDetails.deleteById(profileRes.getUserId());

				userTypeRoleTypeMapRepository.deleteById(profileRes.getUserId());
				response1.setStatus("Failure");
				response1.setErrorDesc(e.getLocalizedMessage());
				return response1;
			}
			String response = "User Created in SCF " + "\n\nLogin Id " + profileRes.getLoginId() + "\n\nPassword "
					+ new String(profileRes.getPassword());

			response1.setMessage(response);
			response1.setStatus("Status");
			return response1;
			/*
			 * } return "Email Id already exist.";
			 */} else {
			response1.setStatus("Failure");
			response1.setErrorDesc("Email Id  or Mobile No already exist.");
			return response1;
		}

		/*
		 * Implementation of business logic for CBS USERTYP + Capability matrix +
		 * BranchCode
		 */

	}

	public UserExistRes checkLoginIdExist(String loginId) {

		UserExistRes res = new UserExistRes();

		UserProfileDetails userProfile = userProfileRepository.findByLoginId(loginId);
		if (userProfile == null) {

			res.setIsExist("Y");
			return res;
		} else {

			res.setIsExist("N");
			return res;
		}
	}

	@Transactional
	public void updatePasswordStatus(String inactive, Integer userId) {

		// userProfileRepository.updatePassword(inactive, userId);
	}

	public Integer emailIdValidate(String emailId) {

		UserProfileDetails res = userProfileRepository.findByEmailId(emailId);

		Integer response = res.getUserId();
		return response;
	}

	@Scheduled(cron = "0 1 1 * * ?")
	public void updateUserActiveStatus() {

		List<UserLoginDetails> res = userLoginDetails.findAll();

		LocalDateTime date1 = LocalDateTime.now();
		List<UserLoginDetails> response = res.stream().filter(item -> item.getUpdateTime().compareTo(date1) > 30)
				.collect(Collectors.toList());
		UserLoginDetails req = new UserLoginDetails();
		for (UserLoginDetails ob : response) {
			req.setUserId(ob.getUserId());
			req.setPassword(ob.getPassword());
			req.setCurrentStatus("InActive");
			req.setAllowPasswordChange("Y");
			req.setUpdateTime(LocalDateTime.now());

		}
		userLoginDetails.save(req);
	}

	public char[] randomPasswordGenerator() {

		String capitalCharacter = "ABCDEFGHIJKLMNOPQRSTRUVXYZ";
		String smallCharacter = "abcdefghijklmnopqrstuvxyz";
		String number = "0123456789";
		String specialCharacter = "!@#$";
		String combinedReq = capitalCharacter + smallCharacter + number + specialCharacter;
		Random randomGenerator = new Random();

		char[] password = new char[8];

		password[0] = smallCharacter.charAt(randomGenerator.nextInt(smallCharacter.length()));
		password[1] = capitalCharacter.charAt(randomGenerator.nextInt(capitalCharacter.length()));
		password[2] = specialCharacter.charAt(randomGenerator.nextInt(specialCharacter.length()));
		password[3] = number.charAt(randomGenerator.nextInt(number.length()));

		for (int i = 4; i < 8; i++) {
			password[i] = combinedReq.charAt(randomGenerator.nextInt(combinedReq.length()));
		}
		return password;
	}

	public String encrypt(String plainText, SecretKey secretKey) throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}

	@Async
	public void sendEmail(String emailId, String loginId, String password) {

		SimpleMailMessage simplemailMessage = new SimpleMailMessage();

		String res = "Welcome to SBI!" + "\n\n Your user ID is created on the platform."
				+ "\n\n We request you to click on the link provided at the end of this email"
				+ " to complete the onbaording process." + "http://localhost:4200/login";
		simplemailMessage.setFrom(userName);
		simplemailMessage.setTo(emailId);
		simplemailMessage.setText(res + "\n\nLoginId: " + loginId + "\nPassword: " + password
				+ "\n For any assistance and clarification please write to us on customer.service@sbi.com"
				+ "\n\n Promissing our best spport." + "\n Warm Regards" + "\n SBI SCF Team");
		simplemailMessage.setSubject("SBI your partner in Growing Business: Your User ID created successful");

		javaMailSender.send(simplemailMessage);
	}
}
