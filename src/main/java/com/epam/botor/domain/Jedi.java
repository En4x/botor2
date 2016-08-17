package com.epam.botor.domain;

import static com.epam.botor.domain.Gender.MALE;

import java.beans.ConstructorProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

public class Jedi extends Person implements ForceUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jedi.class);
	
	public static final String THE_NAME_OF_THE_DARK_LEADER = "Geza Gizner";
	
	private LightSabre lightSabre;
	
	private Jedi padavan; 
	


	@ConstructorProperties( { "name", "gender"})
    public Jedi(String name, Gender gender) {
		super(name, gender);
	}

	@Override
    public ForceSide getAlliance() {
        return ForceSide.LIGHT;
    }

	public String fight() {
		return lightSabre == null ? "no sabre" : lightSabre.hit();
	}

	public static Jedi createJediMaster(String name, Jedi padavan) {
		Jedi jedi = new Jedi(name, MALE);
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
		return "Jedi [" + getName() + "]";
	}

	@Required
	public void setLightSabre(LightSabre lightSabre) {
		this.lightSabre = lightSabre;
	}

	
	public LightSabre getLightSabre() {
		return lightSabre;
	}

	public void setPadavan(Jedi padavan) {
		this.padavan = padavan;
	}
	
	public Jedi getPadavan() {
		return padavan;
	}
	
	
}
