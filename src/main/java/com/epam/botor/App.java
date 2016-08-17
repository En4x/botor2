package com.epam.botor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.botor.domain.Battle;

/**
 * Jedi Application
 *
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			
			Battle battle = context.getBean("starWarsBattle", Battle.class);
			LOGGER.debug(context.getBean("redSabre").toString());
			battle.battle();
			
			
		}
		

	}
}



