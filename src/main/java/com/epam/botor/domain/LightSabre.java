package com.epam.botor.domain;

public class LightSabre extends Weapon implements EnergyWeapon {

    public LightSabre(final String name, final int damage) {
        super(name, damage);
        // TODO Auto-generated constructor stub
    }

	public int getIdentityHashCode() {
		return System.identityHashCode(this);
	}

	public String hit() {
		return "Tyutyutyu";
	}

	@Override
	public String toString() {
		return "LightSabre [toString()=" + super.toString() + "]";
	}
	
	
	

}
