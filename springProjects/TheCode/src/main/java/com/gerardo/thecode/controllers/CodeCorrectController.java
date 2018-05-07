package com.gerardo.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeCorrectController {

	@RequestMapping("/code")
	public String success () {
		return "views/code.jsp";
	}
}
