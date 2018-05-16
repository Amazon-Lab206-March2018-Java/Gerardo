package com.gerardo.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.relationships.models.Person;
import com.gerardo.relationships.services.PersonService;

@Controller
public class PersonController {
	
	PersonService service;
	
	public PersonController(PersonService service) {
		this.service = service;
	}
	
	@RequestMapping ("/persons/new")
	public String personForm (@ModelAttribute ("person") Person person) {
		
		return "views/newPerson.jsp";
	}
	
	@PostMapping ("/persons/new")
	public String createPerson (@Valid @ModelAttribute ("person") Person person) {
		service.addPerson(person);
		return "redirect:/";
	}
}
