package com.epam.botor.domain;

import static com.epam.botor.domain.Gender.MALE;

import java.beans.ConstructorProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jedi extends Person implements ForceUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jedi.class);
	
	
	private final LightSabre lightSabre;
	
	private Jedi padavan; 
	
	@ConstructorProperties( { "name", "gender", "sabre" })
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

	public static Jedi createJediMaster(String name, Jedi padavan) {
		Jedi jedi = new Jedi(name, MALE, null);
		jedi.padavan = padavan;
		return jedi;
	}

	public LightSabre createUglyLightSabre(int damage) {
		return new LightSabre("Ugly light sabre of " + getName(), damage);
	}
	
	
	public void defaultInit() {
		LOGGER.debug("Hello Jedi " + getName());
	}
	
	@Override
	public String toString() {
		return "Jedi [lightSabre=" + lightSabre + ", padavan=" + padavan + ", toString()=" + super.toString() + "]";
	}
	
	
}
