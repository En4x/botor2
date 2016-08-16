package com.epam.botor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.botor.domain.Jedi;
import com.epam.botor.domain.LightSabre;

/**
 * Jedi Application
 *
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			Jedi jedi = context.getBean("joda", Jedi.class);
			
			
			LOGGER.debug(jedi.fight());
			
			LightSabre red;  
			red = context.getBean("redSabre", LightSabre.class);
			LOGGER.debug(red + ": " + red.getIdentityHashCode());

			red = context.getBean("redSabre", LightSabre.class);
			LOGGER.debug(red + ": " + red.getIdentityHashCode());

			red = context.getBean("redSabre", LightSabre.class);
			LOGGER.debug(red + ": " + red.getIdentityHashCode());

			LightSabre blue;  
			blue = context.getBean("blueSabre", LightSabre.class);
			LOGGER.debug(blue + ": " + blue.getIdentityHashCode());

			blue = context.getBean("blueSabre", LightSabre.class);
			LOGGER.debug(blue + ": " + blue.getIdentityHashCode());

			blue = context.getBean("blueSabre", LightSabre.class);
			LOGGER.debug(blue + ": " + blue.getIdentityHashCode());

			
			LOGGER.debug("" + context.getBean("sidius", Jedi.class));
			
			LOGGER.debug("" + context.getBean("uglyLightSabre"));
			
			LOGGER.debug("" + context.getBean("freeMemoryLightSabre"));
			LOGGER.debug("" + context.getBean("obiVanKenobi"));
			LOGGER.debug("" + context.getBean("anakin"));
			
			
		}
		

	}
}


