package com.gerardo.funsies2.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gerardo.funsies2.models.User;
import com.gerardo.funsies2.repositories.RoleRepository;
import com.gerardo.funsies2.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private BCryptPasswordEncoder passEncoder;
	
	public UserService (UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder passEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passEncoder = passEncoder;
	}
	
	public User saveAsUser (User user) {
		
		String password = user.getPassword();
		password = passEncoder.encode(password);
		user.setPassword(password);
		
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		
		return userRepo.save(user);
	}
	
	public User saveAsAdmin (User user) {
		
		String password = user.getPassword();
		password = passEncoder.encode(password);
		user.setPassword(password);
		
		user.setRoles( roleRepo.findAll() );
		
		return userRepo.save(user);
	}
	
	public void saveUser (User user) {
		userRepo.save(user);
	}
	
	public User findByEmail (String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findById (Long id) {
		return userRepo.findById(id).get();
	}
	
	public void deleteUser (Long id) {
		userRepo.deleteById(id);
	}
	
	public List<User> getAllUsers () {
		return userRepo.findAll();
	}
}
