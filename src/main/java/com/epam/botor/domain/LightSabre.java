package com.epam.botor.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LightSabre extends Weapon implements EnergyWeapon, InitializingBean, DisposableBean {

    public LightSabre(final String name, final int damage) {
        super(name, damage);
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

	@Override
	public void destroy() throws Exception {
		System.out.printf("%s destroy()\n", getName());
		
	}

	public void destroy2() throws Exception {
		System.out.printf("%s destroy2()\n", getName());		
	}

	public void init() throws Exception {
		System.out.printf("%s init()\n", getName());		
	}

	@PreDestroy
	public void preDestroy() throws Exception {
		System.out.printf("%s preDestroy()\n", getName());		
	}

	@PostConstruct
	public void postConstruct() throws Exception {
		System.out.printf("%s postConstruct()\n", getName());		
	}

	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.printf("%s afterPropertiesSet()\n", getName());		
	}
	
	
	
	

}
