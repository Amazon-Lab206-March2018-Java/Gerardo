package com.gerardo.grouplanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class UpdateLanguageController {
	
	private LanguageService langService;
	
	public UpdateLanguageController (LanguageService serv) {
		langService = serv;
	}
	
	@RequestMapping ("/update_lang/{lang_id}")
	public String updateLanguage (@PathVariable ("lang_id") int lang_id,
								  @Valid @ModelAttribute ("lang") Language lang, BindingResult result )
	{
		if (result.hasErrors()) {
			return "views/showLanguage.jsp";
		}
		System.out.println("GOT HERE!");
		langService.updateLanguage(lang, lang_id);
		return "redirect:/";
	}
	
	
}
