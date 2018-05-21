package com.gerardo.funsies2.controllers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gerardo.funsies2.models.Idea;
import com.gerardo.funsies2.models.User;
import com.gerardo.funsies2.services.IdeaService;
import com.gerardo.funsies2.services.RoleService;
import com.gerardo.funsies2.services.UserService;
import com.gerardo.funsies2.validators.UserValidator;

@Controller
public class UserController {
	
	private UserService userService;
	private UserValidator userValidator;
	private IdeaService ideaService;
	
	public UserController (UserService userService, UserValidator userValidator, RoleService roleService, IdeaService ideaService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.ideaService = ideaService;
	}
	
	@RequestMapping ("/login")
	public String index(@ModelAttribute ("user") User user, @RequestParam (value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if (error!=null) {
			model.addAttribute("errorMessage", "Invalid credentials, please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
    	
		return "views/index.jsp";
	}
	
	@PostMapping ("/registration")
	public String registration (@Valid @ModelAttribute ("user") User user, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return "views/index.jsp";
		}
		
		userService.saveAsUser(user);


		try {
			request.login(user.getEmail(), user.getPasswordConfirmation());
		} catch (ServletException e) {
			System.out.println("IT DID NOT WORK :C");
		}
		
		return "redirect:/ideas";
	}
	
	@RequestMapping (value = {"/", "/ideas"})
	public String dashboard (Principal principal, Model model) {
		
		String email = principal.getName();
		
		User user = userService.findByEmail(email);

		model.addAttribute("currentUser", user);
		model.addAttribute("ideasList", ideaService.getAllIdeas());
		return "views/dashboard.jsp";
	}
	
	@RequestMapping ("/ideas/{idea_id}/like")
	public String likeDislike (@PathVariable ("idea_id") Long idea_id, Principal principal) {
		
		User currentUser = userService.findByEmail( principal.getName() );
		Idea idea = ideaService.findIdea(idea_id);
		
		if (! currentUser.getLikedIdeas().contains(idea)) {
			currentUser.likeIdea(idea);
		} else {
			currentUser.dislikeIdea(idea);
		}
		
		userService.saveUser(currentUser);
		
		return "redirect:/ideas";
	}
}