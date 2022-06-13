package com.usermanagement.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.userdto.CreateRoleRequest;
import com.usermanagement.userdto.EditRoleDetailsRequest;
import com.usermanagement.userdto.RoleBasedScreenResponse;
import com.usermanagement.userdto.RoleDetailsListResponse;
import com.usermanagement.userdto.RoleResponse;
import com.usermanagement.userdto.RoleScreenRequest;
import com.usermanagement.userdto.RoleTypeUpdateResponse;
import com.usermanagement.userdto.RoleTypesResponse;
import com.usermanagement.userdto.UpdateRoleRequest;
import com.usermanagement.userdto.UpdateScreenRolesRequest;
import com.usermanagement.usermodel.RoleScreenMap;
import com.usermanagement.usermodel.RoleTypeDetails;
import com.usermanagement.usermodel.UserIdRoleId;
import com.usermanagement.usermodel.UserProfileDetails;
import com.usermanagement.usermodel.UserType;
import com.usermanagement.userrepository.RoleRepository;
import com.usermanagement.userrepository.RoleScreenMapRepository;
import com.usermanagement.userrepository.UserProfileRepository;
import com.usermanagement.userrepository.UserTypeRepository;
import com.usermanagement.userrepository.UserTypeRoleTypeMap;
import com.usermanagement.utility.UtilityConstants;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserTypeRepository userTypeRepository;

	@Autowired
	UserProfileRepository userProfileRepository;

	@Autowired
	UserTypeRoleTypeMap roleTypeRepository;
	
	@Autowired
	RoleScreenMapRepository roleScreenMapRepository;
	
	public RoleResponse save(CreateRoleRequest request) {
		RoleResponse roleResponse = new RoleResponse();
		if (!roleRepository.existsByRoleType(request.getRoleType()) || !request.getUserRoleType().equals("ADMIN")) {
			List<UserType> userTypeModelList = userTypeRepository.findByUserType(request.getRoleType());
			boolean userRoleExists = false;
			for (UserType userTypeModel : userTypeModelList) {
				if (userTypeModel.getRoleType().equalsIgnoreCase(request.getRoleType())) {
					userRoleExists = true;
				}
			}
			if (!userRoleExists) {	
				RoleTypeDetails roleMaster = new RoleTypeDetails();
				roleMaster.setRoleId(roleRepository.getMaxRoleId()+1);
				roleMaster.setRoleDescription(request.getRoleDescription());
				roleMaster.setRoleType(request.getRoleType());
				roleRepository.save(roleMaster);

				UserType userTypeModel = new UserType();
				userTypeModel.setUserTypeId(userTypeRepository.getMaxUserTypeId()+1);
				userTypeModel.setRoleType(request.getRoleType());
				userTypeModel.setUserType(request.getUserType());
				userTypeModel.setUserTypeBelongs(request.getIsCbsUser());
				userTypeRepository.save(userTypeModel);
				
				roleResponse.setData(roleMaster);
				roleResponse.setStatus_msg(UtilityConstants.ROLE_CREATION_SUCCESSFUL);
				roleResponse.setStatus(UtilityConstants.SUCCESS);
				roleResponse.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
			} else {
				roleResponse.setStatus_msg(UtilityConstants.ROLE_TYPE_EXISTS);
				roleResponse.setStatus(UtilityConstants.FAILURE);
				roleResponse.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
			}
		} else {
			roleResponse.setStatus_msg(UtilityConstants.EDIT_ROLE_NOTALLOWED);
			roleResponse.setStatus(UtilityConstants.FAILURE);
			roleResponse.setStatus_code(UtilityConstants.HTTPSTATUS_OK);			
		}

		
		return roleResponse;
	}

	public RoleTypesResponse getRoles(Integer userId) {
		UserProfileDetails tempUserProfileDetails = userProfileRepository.findByUserId(userId);
		RoleTypesResponse response = new RoleTypesResponse();

		if (tempUserProfileDetails != null) {
			String tempUserType = tempUserProfileDetails.getEntityId();

			List<UserType> userRoleTypeList = userTypeRepository.findByUserType(tempUserType);
			response.setData(userRoleTypeList);
			response.setStatus_msg(UtilityConstants.ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.SUCCESS);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		} else {
			response.setStatus_msg(UtilityConstants.NO_ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		}
		return response;
	}
	
	public RoleDetailsListResponse getAllRoles() {
		List<RoleTypeDetails> tempUserRoleTypeList = roleRepository.findAll();
		RoleDetailsListResponse response = new RoleDetailsListResponse();

		if (tempUserRoleTypeList.isEmpty()) {
			response.setStatus_msg(UtilityConstants.NO_ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);			
		} else {
			response.setData(tempUserRoleTypeList);
			response.setStatus_msg(UtilityConstants.ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.SUCCESS);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		}
		return response;
	}
	
	public RoleDetailsListResponse editRoleDetails(EditRoleDetailsRequest request) {
		RoleDetailsListResponse response = new RoleDetailsListResponse();
		
		RoleTypeDetails requestUpdate = new RoleTypeDetails();
		
		if(request.getRoleType().equals("ADMIN")) {
			requestUpdate.setRoleDescription(request.getRoleDescription());
			requestUpdate.setRoleId(request.getRoleTypeId());
			requestUpdate.setRoleType(request.getRoleType());
			
			roleRepository.save(requestUpdate);
			List<RoleTypeDetails> tempUserRoleTypeList = roleRepository.findAll();
			
	      	response.setData(tempUserRoleTypeList);
			response.setStatus_msg(UtilityConstants.ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.SUCCESS);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);	
		} else {
			response.setStatus_msg(UtilityConstants.EDIT_ROLE_NOTALLOWED);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);	
		}
		
		return response;
	}

	public RoleTypeUpdateResponse updateRole(UpdateRoleRequest request) {
		UserProfileDetails tempUserProfileDetails = userProfileRepository.findByUserId(request.getUserId());
		String tempUserType = tempUserProfileDetails.getEntityId();
		RoleTypeUpdateResponse response = new RoleTypeUpdateResponse();	
		Boolean isNoRoleTypeExists = false;

		if (tempUserType.equals(request.getUserType())) {
			List<UserType> userTypeModelList = userTypeRepository.findByUserType(tempUserType);

			for (UserType userTypeModel : userTypeModelList) {
				if (userTypeModel.getRoleType().equals(request.getExistingRoleType()) && 
						roleRepository.existsByRoleType(request.getExistingRoleType())) {
					isNoRoleTypeExists = true;
					userTypeModel.setRoleType(request.getNewRoleType());
					userTypeModel.setUserTypeId(userTypeModel.getUserTypeId());
					userTypeRepository.save(userTypeModel);
					
					RoleTypeDetails tempRoleMaster = roleRepository.findByRoleType(request.getExistingRoleType());
					tempRoleMaster.setRoleType(request.getNewRoleType());
					tempRoleMaster.setRoleId(tempRoleMaster.getRoleId());
					tempRoleMaster.setRoleDescription(request.getRoleDescription());
					roleRepository.save(tempRoleMaster);
														
					response.setData(tempRoleMaster);
					response.setStatus_msg(UtilityConstants.ROLE_UPDATE_SUCCESSFUL);
					response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
					response.setStatus(UtilityConstants.SUCCESS);
					return response;				} 
			} 
		} else {
			response.setStatus_msg(UtilityConstants.NO_USER_TYPE_FOUND);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
			response.setStatus(UtilityConstants.FAILURE);
			
			return response;
		}
		if(!isNoRoleTypeExists){
			response.setStatus_msg(UtilityConstants.NO_ROLE_TYPE_EXISTS);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
			response.setStatus(UtilityConstants.FAILURE);
			
			return response;
		}		
		response.setStatus_msg(UtilityConstants.UNKNOWN_ERROR);
		response.setStatus(UtilityConstants.FAILURE);
		response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		
		return response;
	}

	public RoleTypesResponse getUserRoleByUserType(String userType) {
		List<UserType> roleTypeList =  userTypeRepository.findByUserType(userType);
		RoleTypesResponse response = new RoleTypesResponse();
		
		if (roleTypeList.isEmpty()) {
			response.setStatus_msg(UtilityConstants.NO_ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		} else {
			response.setData(roleTypeList);
			response.setStatus_msg(UtilityConstants.ROLE_TYPES_FOUND);
			response.setStatus(UtilityConstants.SUCCESS);
			response.setStatus_code(UtilityConstants.HTTPSTATUS_OK);
		}
		return response;
	}
	
	public RoleBasedScreenResponse getRoleBasedScreens(RoleScreenRequest request) {
				
		UserIdRoleId userIdRoleId = new UserIdRoleId();
		userIdRoleId.setUserId(request.getUserId());
		userIdRoleId.setRoleTypeId(request.getRoleTypeId());
		
		Optional<RoleScreenMap> roleScreenMapList = roleScreenMapRepository.findById(userIdRoleId);																	

		RoleBasedScreenResponse response = new RoleBasedScreenResponse();
		
		if(roleScreenMapList.isEmpty()){
			response.setStatus_msg(UtilityConstants.NO_SCREENS_FOUND);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.SUCCESS);	
		}else {
			List<RoleScreenMap> tempRoleScreenMapList = roleScreenMapList.stream().toList();
			response.setData(tempRoleScreenMapList);
			response.setStatus_msg(UtilityConstants.SCREENS_ROLES_FOUND);
			response.setStatus(UtilityConstants.HTTPSTATUS_OK);
			response.setStatus_code(UtilityConstants.SUCCESS);	
		}
		
		return response;
	}
	

	public RoleBasedScreenResponse updateRoleBasedScreens(UpdateScreenRolesRequest request) {
				
		UserIdRoleId userIdRoleId = new UserIdRoleId();
		userIdRoleId.setUserId(request.getUserId());
		userIdRoleId.setRoleTypeId(request.getRoleTypeId());
		
		Optional<RoleScreenMap> roleScreenMapList = roleScreenMapRepository.findById(userIdRoleId);	
		

		RoleBasedScreenResponse response = new RoleBasedScreenResponse();
		
		if(roleScreenMapList.isEmpty()){
			response.setStatus_msg(UtilityConstants.UNKNOWN_ERROR);
			response.setStatus(UtilityConstants.FAILURE);
			response.setStatus_code(UtilityConstants.SUCCESS);	
		}else {
			List<RoleScreenMap> tempRoleScreenMapList = roleScreenMapList.stream().toList();
			
			RoleScreenMap updateReq = tempRoleScreenMapList.get(0);
			updateReq.setAddAccess(request.getAddAccess());
			updateReq.setDeleteAccess(request.getDeleteAccess());
			updateReq.setEditAccess(request.getEditAccess());
			updateReq.setViewAccess(request.getViewAccess());
			updateReq.setIsAccessAllowed(request.getIsAccessAllowed());
			updateReq.setIsMobileChannel(request.getIsMobileChannel());
			updateReq.setIsInternetChannel(request.getIsInternetChannel());
			updateReq.setId(userIdRoleId);
			
			RoleScreenMap updateResponse = roleScreenMapRepository.save(updateReq);
			List<RoleScreenMap> updateResponseList = new ArrayList<>();
			updateResponseList.add(updateResponse);
					
			response.setData(updateResponseList);
			response.setStatus_msg(UtilityConstants.SCREENS_ROLES_UPDATED);
			response.setStatus(UtilityConstants.HTTPSTATUS_OK);
			response.setStatus_code(UtilityConstants.SUCCESS);	
		}
		
		return response;
	}


}
