package com.epam.botor.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LightSabre extends Weapon implements EnergyWeapon {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jedi.class);
	
	private Color color;
	
	
    public LightSabre(final String name, final int damage) {
        super(name, damage);
        this.color = null;
    }

    public LightSabre(final String name, final String unused) {
        super(name, -1);
        this.color = null;
    }

    public LightSabre(final String name, final Runtime runtime) {
        super(name, (int)runtime.freeMemory());
        this.color = null;
    }
    
    
	public int getIdentityHashCode() {
		return System.identityHashCode(this);
	}

	public String hit() {
		return getName() + ": " + getDamage() + " * Tyutyutyu";
	}

	
	@Override
	public String toString() {
		return "LightSabre [color=" + color + ", toString()=" + super.toString() + "]";
	}

//	@Override
//	public void destroy() throws Exception {
//		LOGGER.debug("{} destroy()", getName());
//		
//	}
//
//	public void destroy2() throws Exception {
//		LOGGER.debug("{} destroy2()", getName());		
//	}

	
//	public void init() throws Exception {
//		LOGGER.debug("{} init()", getName());		
//	}

//	@PreDestroy
//	public void preDestroy() throws Exception {
//		LOGGER.debug("{} preDestroy()", getName());		
//	}
//
//	@PostConstruct
//	public void postConstruct() throws Exception {
//		LOGGER.debug("{} postConstruct()", getName());		
//	}

	
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		LOGGER.debug("{} afterPropertiesSet()", getName());		
//	}

	public void setColor(Color color) {
		this.color = color;
	}

}
