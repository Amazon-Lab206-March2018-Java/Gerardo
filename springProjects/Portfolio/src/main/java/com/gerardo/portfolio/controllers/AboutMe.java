package com.gerardo.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutMe {
	
	@RequestMapping("/about_me")
	public String aboutMe () {
		return "forward:/about_me.html";
	}
}
