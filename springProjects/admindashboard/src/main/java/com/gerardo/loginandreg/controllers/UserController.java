package com.gerardo.loginandreg.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gerardo.loginandreg.models.User;
import com.gerardo.loginandreg.services.UserService;
import com.gerardo.loginandreg.validators.UserValidator;

@Controller
public class UserController {
	
	private UserService userService;
	private UserValidator userValidator;
	
	public UserController (UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
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
		return "redirect:/dashboard";
	}
	
	@RequestMapping (value = {"/", "/dashboard"})
	public String dashboard (Principal principal, Model model) {
		String email = principal.getName();
		
		//System.out.println ( userService.setLastSignInDate(new Date(), userService.findByEmail(email).getId()) );
		model.addAttribute("currentUser", userService.findByEmail(email));
		return "views/dashboard.jsp";
	}
}
