package com.gerardo.web.models;

import java.util.Random;

public class Game {
	private int randomNumber;
	
	public Game () {
		 generateNumber();
	}
	
	public void generateNumber () {
		Random random = new Random ();
		randomNumber = random.nextInt(100)+1;
	}
	
	public int getRandomNumber () {
		return randomNumber;
	}
		
}
