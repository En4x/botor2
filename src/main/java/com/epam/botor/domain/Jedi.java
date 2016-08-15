package com.epam.botor.domain;

public class Jedi {

	private final LightSabre lightSabre;

	public Jedi(LightSabre lightSabre) {
		this.lightSabre = lightSabre;
	}
	
	public String fight() {
		return lightSabre.hit();
	}
	
}
