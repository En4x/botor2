package com.epam.botor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.botor.domain.Jedi;

/**
 * Jedi Application
 *
 */
public class App {
	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Jedi jedi = context.getBean("joda", Jedi.class);
		System.out.println(jedi.fight());

	}
}
