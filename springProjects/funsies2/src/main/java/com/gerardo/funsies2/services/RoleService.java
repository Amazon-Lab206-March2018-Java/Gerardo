package com.gerardo.funsies2.services;

import org.springframework.stereotype.Service;

import com.gerardo.funsies2.models.Role;
import com.gerardo.funsies2.repositories.RoleRepository;

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
