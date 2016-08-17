package com.epam.botor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import com.epam.botor.domain.Battle;
import com.epam.botor.domain.Fight;

/**
 * Jedi Application
 *
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = 
				new GenericGroovyApplicationContext("file:applicationContext.groovy");) {
			
			Battle battle = context.getBean("starWarsBattle", Battle.class);
			context.getBean(Fight.class).fight();
			battle.battle();
			
			
		}
		

	}
}



