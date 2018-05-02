package com.gerardo.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Projects {
	
	@RequestMapping ("/projects")
	public String projects () {
		return "forward:/projects.html";
	}

}
