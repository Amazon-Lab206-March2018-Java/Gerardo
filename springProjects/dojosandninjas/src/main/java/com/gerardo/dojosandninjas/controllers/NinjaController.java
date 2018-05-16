package com.gerardo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.dojosandninjas.models.Dojo;
import com.gerardo.dojosandninjas.models.Ninja;
import com.gerardo.dojosandninjas.services.DojoService;
import com.gerardo.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	private NinjaService service;
	private DojoService dojoService;
	
	public NinjaController (NinjaService service, DojoService dojoService) {
		this.service = service;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninjas/new")
	public String addNinjaForm (@ModelAttribute ("ninja") Ninja ninja, Model model) {
		List <Dojo> dojos =  dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "views/addNinja.jsp";
	}
	
	@PostMapping ("/ninjas/new")
	public String addNinja (@Valid @ModelAttribute ("ninja") Ninja ninja) {
		service.addNinja(ninja);
		Long id = ninja.getDojo().getId();
		return "redirect:/dojos/"+id;
	}
}