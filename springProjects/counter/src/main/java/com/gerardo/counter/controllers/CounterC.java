package com.gerardo.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterC {
	
	@RequestMapping ("/counter")
	public String counter() {
		return "/counter.jsp";
	}
}
