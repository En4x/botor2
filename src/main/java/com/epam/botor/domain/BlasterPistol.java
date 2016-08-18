package com.epam.botor.domain;

public class BlasterPistol extends Weapon implements Blaster {

    public BlasterPistol(final String name, final int damage) {
        super(name, damage);
        // TODO Auto-generated constructor stub
    }

	@Override
	public String toString() {
		return "BlasterPistol [getName()=" + getName() + ", getDamage()=" + getDamage() + "]";
	}

	@Override
	public String shoot() {
		return "tyu tyu tu";
	}

    
}
