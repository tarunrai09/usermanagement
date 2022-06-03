package com.usermanagement.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.usermanagement.userservice.RoleService;

@RestController
@RequestMapping(name = "/sbi/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;

	@PostMapping(value = "/createRole", consumes = "application/json", produces = "application/json")
	public RoleResponseDTO createRole(@RequestBody CreateRoleRequestDTO request){		
		return roleService.save(request);
	}	
	
	@GetMapping(value = "/getRoles", consumes = "application/json", produces = "application/json")
	public RoleTypesResponseDTO geteRoles(@PathVariable String request){
		return roleService.getRoles(request);
	}
	
	@PutMapping(value = "/getRoles", consumes = "application/json", produces = "application/json")
	public RoleTypeUpdateResponseDTO updateRole(@RequestBody UpdateRoleRequestDTO request){
		return roleService.updateRole(request);
	}
	
	@GetMapping(value = "/checkStatus")
	public String geteRoles(){
		return "I am Up!";
	}
	
}
