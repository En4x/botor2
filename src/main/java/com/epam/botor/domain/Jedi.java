package com.epam.botor.domain;

public class Jedi {

	private final LightSabre lightSabre;

	public Jedi() {
		lightSabre = new LightSabre("LightSabre", 100);
	}
	
	public String fight() {
		return lightSabre.hit();
	}
	
}
