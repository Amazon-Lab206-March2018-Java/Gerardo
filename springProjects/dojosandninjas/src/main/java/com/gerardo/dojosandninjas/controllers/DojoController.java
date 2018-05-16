package com.gerardo.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.dojosandninjas.models.Dojo;
import com.gerardo.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	private DojoService service;
	
	public DojoController (DojoService service) {
		this.service = service;
	}
	
	@RequestMapping ("/dojos/new")
	public String addDojoForm (@ModelAttribute ("dojo") Dojo dojo) {
		return "views/addDojo.jsp";
	}
	
	@PostMapping ("/dojos/new")
	public String addDojo (@Valid @ModelAttribute ("dojo") Dojo dojo) {
		service.addDojo(dojo);
		return "redirect:/";
	}
	
	@RequestMapping ("/dojos/{dojo_id}")
	public String showDojo (@PathVariable ("dojo_id") Long dojo_id, Model model) {
		Dojo dojo = service.findDojoById(dojo_id);
		model.addAttribute ("dojo", dojo);
		return "views/showDojo.jsp";
	}
}
