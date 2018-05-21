package com.gerardo.funsies2.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gerardo.funsies2.models.Idea;
import com.gerardo.funsies2.models.User;
import com.gerardo.funsies2.services.IdeaService;
import com.gerardo.funsies2.services.UserService;

@Controller
public class IdeaController {
	
	private IdeaService ideaService;
	private UserService userService;
	
	public IdeaController (IdeaService ideaService, UserService userService) {
		
		this.ideaService = ideaService;
		this.userService = userService;
	}
	
	@RequestMapping ("/ideas/new")
	public String newIdeaForm (@ModelAttribute ("idea") Idea idea) {
		
		return "views/createIdea.jsp";
	}
	
	@PostMapping ("/ideas/new")
	public String createIdea (@Valid @ModelAttribute ("idea") Idea idea, BindingResult result, Principal principal) {
		
		if (result.hasErrors()) {
			return "views/createIdea.jsp";
		}
		
		User creator = userService.findByEmail(principal.getName());
		idea.setCreator(creator);
		ideaService.saveIdea(idea);
		
		return "redirect:/ideas";
	}
	
	@RequestMapping ("ideas/{id}")
	public String showIdea (@PathVariable ("id") Long id, Principal principal, Model model) {
		
		Long currentUserId = userService.findByEmail(principal.getName()).getId();
		Idea idea = ideaService.findIdea(id);
		
		model.addAttribute("currentUserId", currentUserId);
		model.addAttribute("idea", idea);
		
		return "views/showIdea.jsp";
	}
	
	@RequestMapping ("ideas/{id}/edit")
	public String editIdeaForm (@PathVariable ("id")Long id, @ModelAttribute ("idea") Idea idea, Principal principal, Model model) {
		
		Long currentUserId = userService.findByEmail(principal.getName()).getId();
		
		if (currentUserId != ideaService.findIdea(id).getCreator().getId()) {
			return "redirect:/ideas";
		}
		
		model.addAttribute("idea", ideaService.findIdea(id));
		
		return "views/editIdea.jsp";
	}
	
	@PostMapping ("ideas/{id}/edit")
	public String updateIdea (@PathVariable ("id")Long id, @Valid @ModelAttribute ("idea") Idea idea, BindingResult result, Principal principal, Model model, RedirectAttributes redirect) {
		
		if (result.hasErrors()) {
			redirect.addFlashAttribute("editErrors", "The content field cannot be empty");
			return "redirect:/ideas/"+id+"/edit";
		}
		
		User creator = userService.findByEmail(principal.getName());
		idea.setCreator(creator);
		ideaService.saveIdea(idea);
		
		return "redirect:/ideas";
	}
	
	@RequestMapping ("ideas/{id}/delete")
	public String deleteIdea (@PathVariable ("id") Long id, Principal principal) {
		
		Long currentUserId = userService.findByEmail(principal.getName()).getId();
		
		if (currentUserId != ideaService.findIdea(id).getCreator().getId()) {
			return "redirect:/ideas";
		}
		
		ideaService.deleteIdea(id);
		return "redirect:/ideas";
	}
}
