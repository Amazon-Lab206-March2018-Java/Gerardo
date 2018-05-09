package com.gerardo.grouplanguages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class DeleteController {
	
	LanguageService langService;
	
	public DeleteController (LanguageService service) {
		langService = service;
	}
	
	@RequestMapping ("/delete/{lang_id}")
	public String delete (@PathVariable ("lang_id") Long lang_id) {
		
		langService.deleteLanguage (lang_id);
		
		return "redirect:/";
	}

}
