package com.epam.botor.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("trooper")
@Scope("prototype")
public class Trooper extends Person {
	private static int counter;
	
	public Trooper(@Value("${trooper.name.default}") String name, @Value("${trooper.gender.default}") Gender gender) {
		super(name + "[" + counter + "]", gender);
		counter++;
	}

	@Override
	public String toString() {
		return "Trooper [getName()=" + getName() + "]";
	}

	@Override
	public String fight() {		
		return "I'll die placccs placss";
	}

	
	
	
}
