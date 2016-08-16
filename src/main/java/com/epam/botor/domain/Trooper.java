package com.epam.botor.domain;

public class Trooper extends Person {

	public Trooper(String name, Gender gender) {
		super(name, gender);
	}

	@Override
	public String toString() {
		return "Trooper [getName()=" + getName() + "]";
	}

	
}
