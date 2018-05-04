package com.gerardo.ninjagold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Reset {
	
	@RequestMapping ("/clear")
	public String reset (HttpSession session) {
		session.setAttribute("gold", 0);
		//pulls the array list that holds the history of events and removes all the events from it
		((ArrayList<String>) session.getAttribute("history")).clear();
		
		return "redirect:/";
	}
}
