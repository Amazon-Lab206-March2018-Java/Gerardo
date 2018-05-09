package com.gerardo.grouplanguages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository repo;
	
	public LanguageService (LanguageRepository repo) {
		this.repo = repo;
	}
	
	public List<Language> getAllLanguages () {
		return repo.findAll();
	}
	
	public Language getLanguage (Long index) {
		return repo.findById(index).get();
	}
	
	public void addLanguage (Language e) {
		repo.save(e);
	}
	
	public void updateLanguage (Language e) {
		System.out.println("THE UPDATED LANGUAGE ID IS: "+e.getId());
		repo.save(e);
	}

	public void deleteLanguage (Long index) {
		repo.deleteById(index);
	}
}
