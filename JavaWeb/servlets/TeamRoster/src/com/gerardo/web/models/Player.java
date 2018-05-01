package com.gerardo.web.models;

public class Player {
	protected String firstName, lastName;
	protected int age;
	
	public Player (String first, String last, int age) {
		firstName = first;
		lastName = last;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
