package com.gerardo.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetMoney {
	
	@RequestMapping(path = "/get_money", method=RequestMethod.POST)
	public String getMoney (@RequestParam (value="money_source") String moneySource, HttpSession session) {
		
		Random random = new Random();
		int gold = (int) session.getAttribute("gold");
		ArrayList<String> history = (ArrayList<String>) session.getAttribute("history");
		SimpleDateFormat df = new SimpleDateFormat ("MMMM dd, yyyy HH:mm:ss a");
		String date = df.format(new Date());
		
		System.out.println(date);
		
		int randomNumber = 0;
		
		if ( moneySource.toString() == "farm".toString()) {
			System.out.println("IF DOES WORKS!");
		}
		
		switch (moneySource) {
			case "farm":
				randomNumber = random.nextInt(11)+10;
				history.add(0, "<p class='green'>You entered a farm and earned "+randomNumber+" gold. ("+date+")</p>");
				System.out.println("FARM GENERATED: "+randomNumber);
				break;
			case "cave":
				randomNumber = random.nextInt(6)+5;
				history.add(0, "<p class='green'>You entered a cave and earned "+randomNumber+" gold. ("+date+")</p>");
				System.out.println("CAVE GENERATED: "+randomNumber);
				break;
			case "house":
				randomNumber = random.nextInt(4)+2;
				history.add(0, "<p class='green'>You entered a house and earned "+randomNumber+" gold. ("+date+")</p>");
				System.out.println("HOUSE GENERATED: "+randomNumber);
				break;
			case "casino":
				randomNumber = random.nextInt(101)-50;
				session.setAttribute("gold", gold);
				if (randomNumber > 0) {
					history.add(0, "<p class='green'>You entered a casino and earned "+randomNumber+" gold. ("+date+")</p>");
				} else {
					history.add(0, "<p class='red'>You entered a casino and lost "+Math.abs(randomNumber)+" gold. Ouch!  ("+date+")</p>");
				}
				System.out.println("CASINO GENERATED: "+randomNumber);
				break;
		}
		
		gold += randomNumber;
		session.setAttribute("gold", gold);
		
		System.out.println("HISTORY ARRAY: "+history);
		System.out.println("CURRENT GOLD: "+gold);
		
		return "redirect:/";		
	}
}
