package com.gerardo.grouplanguages.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.grouplanguages.models.Language;
import com.gerardo.grouplanguages.services.LanguageService;

@Controller
public class IndexController {
	
	private LanguageService langService;
	
	public IndexController (LanguageService langService) {
		this.langService = langService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute ("lang") Language lang, HttpSession session, Model model) {
//		if (session.getAttribute("languages")==null) {
//			ArrayList<Language> languages = langService.getAllLanguages();
//			session.setAttribute("languages", languages);
//			System.out.println("IN IF----");
//		}
		ArrayList<Language> languages = langService.getAllLanguages();
		System.out.println("ARRAYLIST: "+languages );
		model.addAttribute("languages", languages);
		return "views/index.jsp";
	}
}
