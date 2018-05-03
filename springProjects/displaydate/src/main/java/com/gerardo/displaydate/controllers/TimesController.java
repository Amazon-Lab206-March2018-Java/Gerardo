package com.gerardo.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimesController {
	
	@RequestMapping("time")
	public String time (Model model) {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
		String _time = df.format(new Date());
		
		model.addAttribute ("time", _time);
		
		return "Time.jsp";
	}
}
