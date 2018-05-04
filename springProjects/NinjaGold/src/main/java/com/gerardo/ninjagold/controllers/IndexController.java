package com.gerardo.ninjagold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index (HttpSession session) {
		if (session.getAttribute("gold")==null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("history")==null) {
			session.setAttribute("history", new ArrayList<String>());
		}
		return "index.jsp";
	}
}
