package com.gerardo.grouplanguages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class EditPageController {
	
	private LanguageService langService;
	
	public EditPageController (LanguageService service) {
		langService = service;
	}
	
	@RequestMapping("edit/{lang_id}")
	public String renderPage (@PathVariable ("lang_id") int lang_id, 
							  @ModelAttribute ("lang") Language lang,
							  Model model)
	{
		Language language =  langService.getLanguage(lang_id);
		model.addAttribute("lang_id", lang_id);
		model.addAttribute("language", language);
		
		return "views/editLanguage.jsp";
	}
}
