package com.epam.botor.config;

import static com.epam.botor.domain.Gender.MALE;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.botor.domain.Army;
import com.epam.botor.domain.EnergyWeapon;
import com.epam.botor.domain.Jedi;
import com.epam.botor.domain.LightSabre;
import com.epam.botor.domain.Person;
import com.epam.botor.domain.Trooper;

@Configuration
public class JediConfig {

	@Autowired
	ApplicationContext ctx;

	@Bean
	public Jedi darthVader(@Qualifier("lightSabre") EnergyWeapon lightSabre) {
		Jedi darthVader = new Jedi("Darth Vader", MALE);
		darthVader.setLightSabre(lightSabre);
		return darthVader;
	}


	@Bean
	public Jedi obiVanKenobi() {
		return new Jedi("Obi Van Kenobi", MALE);
	}
	
	@Bean
	public Army armyOfLight() {
		
		Set<Person> lightFighters = new HashSet<>();
		lightFighters.add(ctx.getBean("trooper", Trooper.class));
		lightFighters.add(ctx.getBean("trooper", Trooper.class));
		lightFighters.add(ctx.getBean("trooper", Trooper.class));
		lightFighters.add(ctx.getBean("trooper", Trooper.class));
		
		Army army = new Army();
		army.setLeader(ctx.getBean("joda", Jedi.class));
		army.setFighters(lightFighters);
		return army;
		
	}

}
