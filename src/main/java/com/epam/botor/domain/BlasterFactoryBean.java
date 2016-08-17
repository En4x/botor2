package com.epam.botor.domain;

import org.springframework.beans.factory.FactoryBean;

public class BlasterFactoryBean implements FactoryBean<Blaster> {

    private final String name;
    private final int damage;
    
	public BlasterFactoryBean(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}

	@Override
	public Blaster getObject() throws Exception {
		return Math.random() > 0.5 ? new BlasterPistol(name, damage) : new BlasterRifle(name, damage);
	}

	@Override
	public Class<?> getObjectType() {
		return Blaster.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
