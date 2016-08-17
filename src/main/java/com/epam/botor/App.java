package com.epam.botor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.botor.domain.Army;
import com.epam.botor.domain.Battle;
import com.epam.botor.domain.BlasterPistol;
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
			
			Battle battle = context.getBean(Battle.class);
			
			battle.battle();
			LOGGER.debug("" + context.getBean("yellowSabre"));
			
		}
		

	}
}



