package com.gerardo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexC {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count")==null) {
			session.setAttribute("count", 1);
		}
		else {
			int count = (int) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
		return "index.jsp";
	}
}