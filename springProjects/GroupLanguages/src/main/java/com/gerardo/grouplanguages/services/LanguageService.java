package com.gerardo.grouplanguages.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.gerardo.grouplanguages.models.Language;

@Service
public class LanguageService {
	
	private ArrayList<Language> languages = new ArrayList<Language> ();
	
	public ArrayList<Language> getAllLanguages () {
		return languages;
	}
	
	public Language getLanguage (int index) {
		return languages.get(index);
	}
	
	public void addLanguage (Language e) {
		languages.add(e);
	}
	
	public int getLanguageIndex (Language e) {
		return languages.indexOf(e);
	}
	
	public void updateLanguage (Language e, int index) {
		languages.set(index, e);
	}
	
	public void deleteLanguage (int index) {
		languages.remove(index);
	}
}
