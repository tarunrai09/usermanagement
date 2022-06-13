package com.usermanagement.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.usermanagement.userservice.RoleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(name = "/sbi/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping(value = "/createRole", consumes = "application/json", produces = "application/json")
	public RoleResponse createRole(@RequestBody CreateRoleRequest createRole) {
		return roleService.save(createRole);
	}

	@GetMapping(value = "/getUserTypeAndRoles/{userId}", consumes = "application/json", produces = "application/json")
	public RoleTypesResponse geteRoles(@PathVariable Integer userId) {
		return roleService.getRoles(userId);
	}

	@PutMapping(value = "/updateRoles", consumes = "application/json", produces = "application/json")
	public RoleTypeUpdateResponse updateRole(@RequestBody UpdateRoleRequest updateRole) {
		return roleService.updateRole(updateRole);
	}
	
	@GetMapping(value = "/getUserRoleByUserType/{userTYpe}")
	public RoleTypesResponse getUserRoleByUserType(@PathVariable String userTYpe) {
		return roleService.getUserRoleByUserType(userTYpe);
	}

	@PostMapping(value = "/getUserRoleScreen",consumes = "application/json", produces = "application/json")
	public RoleBasedScreenResponse getUserRoleScreen(@RequestBody RoleScreenRequest request) {
		return roleService.getRoleBasedScreens(request);
	}
	
	@PutMapping(value = "/updateUserRoleScreen",consumes = "application/json", produces = "application/json")
	public RoleBasedScreenResponse updateUserRoleScreen(@RequestBody UpdateScreenRolesRequest request) {
		return roleService.updateRoleBasedScreens(request);
	}
	
	@GetMapping(value = "/getAllRoles")
	public RoleDetailsListResponse getAllRoles() {
		return roleService.getAllRoles();
	}
	
	@PutMapping(value = "/editRoleDetails",consumes = "application/json", produces = "application/json")
	public RoleDetailsListResponse editRoleDetails(@RequestBody EditRoleDetailsRequest request){
		return roleService.editRoleDetails(request);
	}
	
	@GetMapping(value = "/checkStatus")
	public String geteRoles() {
		return "I am Up!";
	}

}
