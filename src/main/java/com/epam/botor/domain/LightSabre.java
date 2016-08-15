package com.epam.botor.domain;

public class LightSabre {
	private final String name;
	private final int damage;
	
	public LightSabre(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
		System.out.printf("Light sabre '%s' created.\n", name);
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
	
	public String getIdentityHashCode() {
		return "" + System.identityHashCode(this);
	}

	@Override
	public String toString() {
		return "LightSabre [name=" + name + ", damage=" + damage + "]";
	}
	
	
}
