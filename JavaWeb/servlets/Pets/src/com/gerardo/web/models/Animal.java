package com.gerardo.web.models;

public class Animal {
	protected String name, breed;
	protected int weight;
	
	public Animal (String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	
	public String getName () {
		return name;
	}
	
	public String getBreed () {
		return breed;
	}
	
	public int getWeight () {
		return weight;
	}
}
