package com.gerardo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.relationships.models.License;
import com.gerardo.relationships.models.Person;
import com.gerardo.relationships.services.LicenseService;
import com.gerardo.relationships.services.PersonService;

@Controller
public class LicenseController {
	
	LicenseService service;
	PersonService personS;
	
	public LicenseController (LicenseService service, PersonService personS) {
		this.service = service;
		this.personS = personS;
	}
	
	@RequestMapping("/licenses/new")
	public String licenseForm (@ModelAttribute ("license") License license, Model model) {
		
		List<Person> licenseless = personS.getLicenseless();
		model.addAttribute("licenseless", licenseless);
		
		return "views/newLicense.jsp";
	}
	
	@PostMapping ("/licenses/new")
	public String createLicense (@Valid @ModelAttribute ("license") License license) {	
		service.addLicense(license);
		return "redirect:/";
	}
	
}
