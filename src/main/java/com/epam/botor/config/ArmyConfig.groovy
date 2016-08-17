package com.epam.botor.config

import java.util.HashMap
import java.util.Map

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration

import com.epam.botor.domain.Army
import com.epam.botor.domain.Gender
import com.epam.botor.domain.Jedi
import com.epam.botor.domain.Person
import com.epam.botor.domain.Trooper

@Configuration
class ArmyConfig {
	
	@Autowired
	ApplicationContext context;
	
	@Bean
	armyOfLight2(@Qualifier("anakin") joda) {
		def army = new Army();
		army.leader = joda;
		def troopers = []
		def trooperSluper = new XmlSlurper().parse(getClass().getResourceAsStream("/troopers.xml"))
		trooperSluper.trooper.each {
			def trooper = context.getBean("trooper", Trooper.class)
			trooper.name = it.@name.text()
			trooper.gender = Gender.valueOf(it.@gender.text())
			troopers.add(trooper)
		}
		army.fighters = troopers
		army		
	}
	
}
