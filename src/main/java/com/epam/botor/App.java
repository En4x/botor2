package com.epam.botor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.botor.domain.Jedi;
import com.epam.botor.domain.LightSabre;

/**
 * Jedi Application
 *
 */
public class App {
	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			Jedi jedi = context.getBean("joda", Jedi.class);
			
			
			System.out.println(jedi.fight());
			
			LightSabre red;  
			red = context.getBean("redSabre", LightSabre.class);
			System.out.println(red + ": " + red.getIdentityHashCode());

			red = context.getBean("redSabre", LightSabre.class);
			System.out.println(red + ": " + red.getIdentityHashCode());

			red = context.getBean("redSabre", LightSabre.class);
			System.out.println(red + ": " + red.getIdentityHashCode());

			LightSabre blue;  
			blue = context.getBean("blueSabre", LightSabre.class);
			System.out.println(blue + ": " + blue.getIdentityHashCode());

			blue = context.getBean("blueSabre", LightSabre.class);
			System.out.println(blue + ": " + blue.getIdentityHashCode());

			blue = context.getBean("blueSabre", LightSabre.class);
			System.out.println(blue + ": " + blue.getIdentityHashCode());

			
			System.out.println(context.getBean("sidius", Jedi.class));
			
		}
		

	}
}


