package com.gerardo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.dojosandninjas.models.Ninja;
import com.gerardo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository repo;
	
	public NinjaService (NinjaRepository repo) {
		this.repo = repo;
	}
	
	public void addNinja (Ninja e) {
		repo.save(e);
	}
	
	public List<Ninja> getAllNinjas () {
		return repo.findAll();
	}
}
