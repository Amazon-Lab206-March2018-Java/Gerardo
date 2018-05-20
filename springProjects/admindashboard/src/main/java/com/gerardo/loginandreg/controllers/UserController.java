package com.gerardo.loginandreg.controllers;

import java.security.Principal;
import java.util.List;

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

import com.gerardo.loginandreg.models.User;
import com.gerardo.loginandreg.services.RoleService;
import com.gerardo.loginandreg.services.UserService;
import com.gerardo.loginandreg.validators.UserValidator;

@Controller
public class UserController {
	
	private UserService userService;
	private UserValidator userValidator;
	private RoleService roleService;
	
	public UserController (UserService userService, UserValidator userValidator, RoleService roleService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.roleService = roleService;
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
		
		if (userService.getAllUsers().size()==0) {
			userService.saveAsAdmin(user);
		} else {
			userService.saveAsUser(user);
		}

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
		
		User user = userService.findByEmail(email);
		
		if (user.getRoles().size()>1) {
			return "redirect:/admin";
		}
		//System.out.println ( userService.setLastSignInDate(new Date(), userService.findByEmail(email).getId()) );
		model.addAttribute("currentUser", user);
		return "views/dashboard.jsp";
	}
	
	@RequestMapping ("/admin")
	public String adminDashboard (Principal principal, Model model) {
		List<User> users_list = userService.getAllUsers();
		User user = userService.findByEmail( principal.getName() );
		
		model.addAttribute("users_list", users_list);
		model.addAttribute ("currentUser", user);
		
		return "views/adminDashboard.jsp";
	}
	
	@RequestMapping ("/admin/make_admin/{id}")
	public String makeAdmin (@PathVariable ("id") Long id) {
		User user = userService.findById(id);
		user.addRole(roleService.findRoleByName("ROLE_ADMIN"));
		userService.saveUser(user);
		
		return "redirect:/admin";
	}
	
	@RequestMapping ("/admin/delete/{id}")
	public String deleteUser (@PathVariable ("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}
