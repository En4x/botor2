package com.epam.botor.domain;

public class LightSabre {
	private final String name;
	private final int damage;
	
	public LightSabre(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}
	
	public String hit() {
		return "tyútyútyútyú";
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}
	
	

}
