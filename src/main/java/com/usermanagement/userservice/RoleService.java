package com.usermanagement.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.userdto.CreateRoleRequestDTO;
import com.usermanagement.userdto.RoleResponseDTO;
import com.usermanagement.userdto.RoleTypeUpdateResponseDTO;
import com.usermanagement.userdto.RoleTypesResponseDTO;
import com.usermanagement.userdto.UpdateRoleRequestDTO;
import com.usermanagement.usermodel.RoleTypeDetails;
import com.usermanagement.usermodel.UserProfileDetails;
import com.usermanagement.usermodel.UserType;
import com.usermanagement.usermodel.UserTypeRoleType;
import com.usermanagement.userrepository.RoleRepository;
import com.usermanagement.userrepository.UserProfileRepository;
import com.usermanagement.userrepository.UserTypeRepository;
import com.usermanagement.userrepository.UserTypeRoleTypeMapRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserTypeRepository userTypeRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	UserTypeRoleTypeMapRepository roleTypeRepository;
	
	public RoleResponseDTO save(CreateRoleRequestDTO request) {
		RoleTypeDetails roleMaster = new RoleTypeDetails();
		if (!roleRepository.existsByRoleType(request.getRoleType())) {
			List<UserType> userTypeModelList = userTypeRepository.findByUserType(request.getRoleType());
			boolean userRoleExists = false;
			for (UserType userTypeModel : userTypeModelList) {
				if (userTypeModel.getRoleType().equalsIgnoreCase(request.getRoleType())) {
					userRoleExists = true;
				}
			}
			if (!userRoleExists) {
				roleMaster.setRoleDescription(request.getRoleDescription());
				roleMaster.setRoleType(request.getRoleType());
				roleRepository.save(roleMaster);

				UserType userTypeModel = new UserType();
				userTypeModel.setRoleType(request.getRoleType());
				userTypeModel.setUserType(request.getUserType());
				userTypeModel.setUserTypeBelongs(request.getIsCbsUser());
				userTypeRepository.save(userTypeModel);

				return createResponse("ROLE CREATION SUCCESSFULL!");
			}
		} else {
			return createResponse("ROLE ALREADY EXISTS!");
		}
		return null;
	}

	private RoleResponseDTO createResponse(String message) {
		RoleResponseDTO roleResponse = new RoleResponseDTO();
		roleResponse.setResponseMessage(message);
		roleResponse.setStatusCode(200);
		return roleResponse;
	}

	public RoleTypesResponseDTO getRoles(Integer userId) {
		UserProfileDetails tempUserProfileDetails = userProfileRepository.findByUserId(userId);
		RoleTypesResponseDTO response = new RoleTypesResponseDTO();

		if (tempUserProfileDetails != null) {
			String tempUserType = tempUserProfileDetails.getEntityId();

			List<UserType> userRoleTypeList = userTypeRepository.findByUserType(tempUserType);
			response.setUserTypeModel(userRoleTypeList);
			response.setMessage("UserId Found");

		} else {
			response.setMessage("Error: UserId Not Found");
		}
		return response;
	}

	public RoleTypeUpdateResponseDTO updateRole(UpdateRoleRequestDTO request) {
		UserProfileDetails tempUserProfileDetails = userProfileRepository.findByUserId(request.getUserId());
		String tempUserType = tempUserProfileDetails.getEntityId();
		RoleTypeUpdateResponseDTO response = new RoleTypeUpdateResponseDTO();	

		if (tempUserType.equals(request.getUserType())) {
			List<UserType> userTypeModelList = userTypeRepository.findByUserType(tempUserType);

			for (UserType userTypeModel : userTypeModelList) {
				if (userTypeModel.getRoleType().equals(request.getExistingRoleType()) && 
						roleRepository.existsByRoleType(request.getExistingRoleType())) {
					
					userTypeModel.setRoleType(request.getNewRoleType());
					userTypeModel.setUserTypeId(userTypeModel.getUserTypeId());
					userTypeRepository.save(userTypeModel);
					
					RoleTypeDetails tempRoleMaster = roleRepository.findByRoleType(request.getExistingRoleType());
					tempRoleMaster.setRoleType(request.getNewRoleType());
					tempRoleMaster.setRoleId(tempRoleMaster.getRoleId());
					tempRoleMaster.setRoleDescription(tempRoleMaster.getRoleDescription());
					roleRepository.save(tempRoleMaster);
														
					response.setUserTypeModel(userTypeModel);
					response.setMessage("SUCCESS - Role Updated!");
					break;
				} 
			} 
		} else {
			response.setUserTypeModel(null);
			response.setMessage("ERROR - User Type Not Found!");
		}
		return response;
	}

	public List<UserTypeRoleType> getUserRoleByUserType(String userType) {
		return roleTypeRepository.findByUserType(userType);
	}

}
