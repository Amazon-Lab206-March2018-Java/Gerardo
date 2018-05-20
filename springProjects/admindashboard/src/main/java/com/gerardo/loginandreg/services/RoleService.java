package com.gerardo.loginandreg.services;

import org.springframework.stereotype.Service;

import com.gerardo.loginandreg.models.Role;
import com.gerardo.loginandreg.repositories.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepo;
	
	public RoleService (RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public Role findRoleByName (String name) {
		return roleRepo.findByName(name).get(0);
	}
}
