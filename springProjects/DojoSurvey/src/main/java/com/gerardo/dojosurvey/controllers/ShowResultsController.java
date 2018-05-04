package com.gerardo.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowResultsController {
	
	@RequestMapping("/show_results")
	public String showResults () {

		return "result.jsp";
	}
}
