package com.gerardo.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatesController {
	
	@RequestMapping("/date")
	public String date (Model model) {
		SimpleDateFormat df = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		String today = df.format(new Date());
		model.addAttribute ("date", today);
		return  "Date.jsp";
	}

}
