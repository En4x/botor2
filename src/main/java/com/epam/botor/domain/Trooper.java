package com.epam.botor.domain;

public class Trooper extends Person {
	private static int counter;
	
	
	public Trooper(String name, Gender gender) {
		super(name + "[" + counter + "]", gender);
		counter++;
	}

	@Override
	public String toString() {
		return "Trooper [getName()=" + getName() + "]";
	}

	
	
	
}
