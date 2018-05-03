package com.gerardo.human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexC {

	@RequestMapping("/")
	public String index( @RequestParam (value="name", defaultValue="Human") String query, Model model ) {
		/*  ( HttpServletRequest request ) can be used to get the request
			String name = request.getParameter("name"); then the request can be used to get the parameters (like a servlet)
			and we can do model.addAttribute("name", name) to pass it to the jsp (just like below)
		*/
		model.addAttribute("name", query);
		
		System.out.println(query);
		return "index.jsp";
	}
}
