package com.gerardo.web.models;

public class Cat extends Animal implements Pet{
	
	public Cat (String name, String breed, int weight) {
		super (name, breed, weight);
	}
	
	public String showAffection () {
		return "Your "+breed+" cat, "+name+", looked at you with some affection, you think";
	}

}
