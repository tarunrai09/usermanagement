package com.usermanagement.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.rolemodel.RoleMaster;
import com.usermanagement.userdto.CreateRoleRequestDTO;
import com.usermanagement.userdto.RoleResponseDTO;
import com.usermanagement.userdto.RoleTypeUpdateResponseDTO;
import com.usermanagement.userdto.RoleTypesResponseDTO;
import com.usermanagement.userdto.UpdateRoleRequestDTO;
import com.usermanagement.userrepository.RoleRepository;
import com.usermanagement.userrepository.UserRoleMapRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleMapRepository userRoleMapRepository;

	public RoleResponseDTO save(CreateRoleRequestDTO request) {
		RoleMaster roleMaster = new RoleMaster();
		roleMaster.setRoleDescription(request.getRoleDescription());
		roleMaster.setRoleType(request.getRoleType());
		roleRepository.save(roleMaster);

		RoleResponseDTO roleResponse = new RoleResponseDTO();
		roleResponse.setResponseMessage("SUCCESS");
		roleResponse.setStatusCode(200);

		return roleResponse;
	}

	public RoleTypesResponseDTO getRoles(String userId) {
		List<Integer> roleIdList = userRoleMapRepository.findByUserId(userId);
		List<String> roleTypeList = new ArrayList<>();
		for (Integer roleId : roleIdList) {
			roleTypeList.add(roleRepository.findByRoleId(roleId));
		}

		RoleTypesResponseDTO response = new RoleTypesResponseDTO();
		response.setUserId(userId);
		response.setRoles(roleTypeList);

		return response;
	}

	public RoleTypeUpdateResponseDTO updateRole(UpdateRoleRequestDTO request) {
		List<Integer> roleIdList = userRoleMapRepository.findByUserId(request.getUserId());
		Integer tempRoleId = 0;
		for (Integer roleId : roleIdList) {
			if(roleRepository.findByRoleId(roleId).equals(request.getRoleType()));
			tempRoleId = roleId;
			roleRepository.deleteById(roleId);
			break;
		}
		
		RoleMaster roleMaster = new RoleMaster();
		roleMaster.setRoleDescription(request.getRoleDescription());
		roleMaster.setRoleId(tempRoleId);
		roleMaster.setRoleType(request.getRoleType());
		
		roleRepository.save(roleMaster);
		
		RoleTypeUpdateResponseDTO response = new RoleTypeUpdateResponseDTO();
		response.setUserId(request.getUserId());
		response.setRoleDescription(request.getRoleDescription());
		response.setRoleType(request.getRoleType());

		return response;
	}

}
