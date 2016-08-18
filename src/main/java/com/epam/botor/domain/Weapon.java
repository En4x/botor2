package com.epam.botor.domain;

public abstract class Weapon {

    private final String name;
    private final int damage;

    public Weapon(final String name, final int damage) {
        super();
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public abstract String shoot();
    
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", damage=" + damage + "]";
	}

    
}
