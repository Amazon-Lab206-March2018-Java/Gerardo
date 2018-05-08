package com.gerardo.grouplanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class AddLanguageController {
	
	private LanguageService langService;
	
	public AddLanguageController (LanguageService langService) {
		this.langService = langService;
	}
	
	@PostMapping("/new_language")
	public String createLanguage (@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {
			return "views/index.jsp";
		}
		langService.addLanguage(lang);
		return "redirect:/";
	}
}
