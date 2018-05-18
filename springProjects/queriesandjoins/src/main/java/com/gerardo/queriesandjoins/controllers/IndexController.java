package com.gerardo.queriesandjoins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerardo.queriesandjoins.services.MainService;

@Controller
public class IndexController {
	
	private MainService service;
	
	public IndexController (MainService service) {
		this.service = service;
	}
	
	@RequestMapping ("/")
	public String index () {
		service.queries();
		return "views/index.jsp";
	}

}
