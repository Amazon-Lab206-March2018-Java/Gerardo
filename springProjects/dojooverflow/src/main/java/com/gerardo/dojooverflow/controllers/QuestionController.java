package com.gerardo.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.dojooverflow.models.Answer;
import com.gerardo.dojooverflow.models.Question;
import com.gerardo.dojooverflow.service.AnswerService;
import com.gerardo.dojooverflow.service.QuestionService;

@Controller
public class QuestionController {

	private QuestionService serv;
	private AnswerService anServ;
	
	public QuestionController (QuestionService serv, AnswerService anServ) {
		this.serv = serv;
		this.anServ = anServ;
	}
	
	@RequestMapping ("/")
	public String dashboard(Model model) {
		model.addAttribute("question_list", serv.getAllQuestions());
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
		serv.addQuestion(question);
		return "redirect:/";
	}
	
	@RequestMapping ("/questions/{id}")
	public String showQuestion (@PathVariable ("id") Long id, @ModelAttribute ("ans") Answer answer, Model model) {
		Question question = serv.getQuestion(id);
		model.addAttribute("question", question);
		return "views/showQuestion.jsp";
	}
	
	@PostMapping ("/questions/{q_id}/new_answer")
	public String addAnswer (@PathVariable ("q_id") Long q_id, @Valid @ModelAttribute ("ans") Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Question question = serv.getQuestion(q_id);
			model.addAttribute("question", question);
			return "views/showQuestion.jsp";
		}
		anServ.saveAnswer(answer);
		//serv.addAnswer (, q_id);
		return "redirect:/questions/"+q_id;
	}
}
