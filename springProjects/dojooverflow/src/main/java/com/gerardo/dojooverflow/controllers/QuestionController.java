package com.gerardo.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.dojooverflow.models.Question;
import com.gerardo.dojooverflow.service.QuestionService;

@Controller
public class QuestionController {

	private QuestionService serv;
	
	public QuestionController (QuestionService serv) {
		this.serv = serv;
	}
	
	@RequestMapping ("/")
	public String dashboard() {
		return "views/dashboard.jsp";
	}
	
	@RequestMapping ("/questions/new")
	public String questionForm (@ModelAttribute ("q") Question question) {
		return "views/newQuestion.jsp";
	}
	
	@PostMapping ("/questions/new")
	public String addQuestion (@Valid @ModelAttribute ("q") Question question, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("THERE ARE ERRORS");
			return "views/newQuestion.jsp";
		}
		System.out.println("QUESTION: "+question);
		return "views/dashboard.jsp";
	}
}
