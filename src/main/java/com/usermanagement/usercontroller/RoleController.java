package com.usermanagement.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.userdto.CreateRoleRequestDTO;
import com.usermanagement.userdto.RoleResponseDTO;
import com.usermanagement.userdto.RoleTypeUpdateResponseDTO;
import com.usermanagement.userdto.RoleTypesResponseDTO;
import com.usermanagement.userdto.UpdateRoleRequestDTO;
import com.usermanagement.usermodel.UserRoleMap;
import com.usermanagement.userservice.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(name = "/sbi/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping(value = "/createRole", consumes = "application/json", produces = "application/json")
	public RoleResponseDTO createRole(@RequestBody CreateRoleRequestDTO createRole) {
		return roleService.save(createRole);
	}

	@GetMapping(value = "/getUserTypeAndRoles/{userId}", consumes = "application/json", produces = "application/json")
	public RoleTypesResponseDTO geteRoles(@PathVariable Integer userId) {
		return roleService.getRoles(userId);
	}

	@PutMapping(value = "/updateRoles", consumes = "application/json", produces = "application/json")
	public RoleTypeUpdateResponseDTO updateRole(@RequestBody UpdateRoleRequestDTO updateRole) {
		return roleService.updateRole(updateRole);
	}
	
	@GetMapping(value = "/getUserRoleByUserType/{userTYpe}")
	public List<UserRoleMap> getUserRoleByUserType(@PathVariable String userTYpe) {
		return roleService.getUserRoleByUserType(userTYpe);
	}

	@GetMapping(value = "/checkStatus")
	public String geteRoles() {
		return "I am Up!";
	}

}
