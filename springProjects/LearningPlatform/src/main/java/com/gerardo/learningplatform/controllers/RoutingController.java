package com.gerardo.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutingController {
	
	@RequestMapping ("m/{chapter}/0483/{assignmentNumber}")
	public String assignment(@PathVariable ("chapter") int chapter,
							 @PathVariable ("assignmentNumber") int assignmentNumber,
							 Model model)
	{
		
		model.addAttribute("content", "The goal of this assignment is to...");
		
		return "views/assignment.jsp";
	}

	@RequestMapping ("m/{chapter}/0553/{lessonNumber}")
	public String lesson(@PathVariable ("chapter") int chapter,
						 @PathVariable ("lessonNumber") String lessonNumber,
						 Model model)
	{
		System.out.println("PathVariable can store into int variables: "+chapter);
		
		switch (lessonNumber) {
			case "0733":
				model.addAttribute("content", "Setting up your servers placeholder");
				break;
			case "0342":
				model.addAttribute("content", "Punch Cards placeholder");
				break;
			case "0348":
				model.addAttribute("content", "Advanced Fortran Intro placeholder");
				break;
		}
		
		return "views/lesson.jsp";
	}
	
}
