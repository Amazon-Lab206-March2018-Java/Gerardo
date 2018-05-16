package com.gerardo.relationships.services;

import org.springframework.stereotype.Service;

import com.gerardo.relationships.models.License;
import com.gerardo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private LicenseRepository repository;

	public LicenseService (LicenseRepository repository) {
		this.repository = repository;
	}
	
	public void addLicense (License e) {
		License.setCounter(repository.count() + 1);
		repository.save(e);
	}
	
	public License findLicenseById (Long id) {
		return repository.findById(id).get();
	}
	
	
}
