package com.gerardo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.dojosandninjas.models.Dojo;
import com.gerardo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository repo;
	
	public DojoService (DojoRepository repo) {
		this.repo = repo;
	}
	
	public void addDojo (Dojo e) {
		repo.save(e);
	}
	
	public List<Dojo> getAllDojos () {
		return repo.findAll();
	}
	
	public Dojo findDojoById (Long id) {
		return repo.findById(id).get();
	}
	
}
