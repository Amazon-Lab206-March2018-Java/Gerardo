package com.gerardo.web.models;

public class Dog extends Animal implements Pet{
	
	public Dog (String name, String breed, int weight) {
		super (name, breed, weight);
	}
	
	public String showAffection () {
		if (weight < 30) {
			return "You created a "+breed+"!\n"+name+" hopped in your lap and cuddled you!";
		}
		else {
			return "You created a "+breed+"!\n"+name+" curled next to you!";
		}
	}

}
