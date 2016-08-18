package com.epam.botor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.botor.config.StarWarsConfig;
import com.epam.botor.domain.Battle;
import com.epam.botor.domain.Fight;
import com.epam.botor.domain.LightSabre;

/**
 * Jedi Application
 *
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(StarWarsConfig.class)) {
			
			Battle battle = context.getBean("starWarsBattle", Battle.class);
			
			Map<String, LightSabre> lightSabres = context.getBeansOfType(LightSabre.class);
			battle.battle();
			for (String lightSabreName : lightSabres.keySet()) {
				LOGGER.debug(
						"{}.switchedOn = {}", lightSabreName, 
							context.getBean(lightSabreName, LightSabre.class).isSwitchedOn());
			}
			
			
			
		}
		

	}
}



