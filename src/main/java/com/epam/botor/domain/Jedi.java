package com.epam.botor.domain;

public class Jedi extends Person implements ForceUser {

	private final LightSabre lightSabre;
	
    public Jedi(String name, Gender gender, LightSabre lightSabre) {
		super(name, gender);
		this.lightSabre = lightSabre;
	}

	@Override
    public ForceSide getAlliance() {
        return ForceSide.LIGHT;
    }

	public String fight() {
		return lightSabre.hit();
	}

}
