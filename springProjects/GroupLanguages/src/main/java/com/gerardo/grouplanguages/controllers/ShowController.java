package com.gerardo.grouplanguages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class ShowController {

	private LanguageService langService;
	
	public ShowController (LanguageService serv) {
		langService = serv;
	}
	
	@RequestMapping ("/show/{lang_id}")
	public String show (@PathVariable ("lang_id") int lang_id, Model model) {
		Language language = langService.getLanguage(lang_id);
		
		model.addAttribute("language", language);
		model.addAttribute("lang_id", lang_id);
		return "views/showLanguage.jsp";
	}
}
