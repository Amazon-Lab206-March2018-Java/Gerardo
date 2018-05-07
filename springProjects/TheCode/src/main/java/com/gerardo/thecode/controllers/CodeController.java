package com.gerardo.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	
	@RequestMapping (path="/guess", method=RequestMethod.POST)
	public String guessCode (@RequestParam ("code") String code, RedirectAttributes redirect) {
		String secretCode = "bushido";
		
		if (secretCode.equals(code)) {
			return "redirect:/code";
		}
		redirect.addFlashAttribute("error", "<p class='red'>You must train harder!</p>");
		return "redirect:/";
	}
}