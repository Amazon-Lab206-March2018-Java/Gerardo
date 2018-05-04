package com.gerardo.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
	
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String form (@RequestParam (value="name") String name,
						@RequestParam (value="location") String location,
						@RequestParam (value="favLang") String favLang,
						@RequestParam (value="comment") String comment,
						RedirectAttributes redirect )
	{
		redirect.addFlashAttribute("name", name);
		redirect.addFlashAttribute("location", location);
		redirect.addFlashAttribute("favLang", favLang);
		redirect.addFlashAttribute("comment", comment);
		
		return "redirect:/show_results";
	}
	
}
