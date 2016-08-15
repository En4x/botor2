package com.epam.botor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.epam.botor.domain.Jedi;

/**
 * Jedi Application
 *
 */
public class App {
	public static void main(String[] args) {

		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

		Jedi jedi = beanFactory.getBean("joda", Jedi.class);
		System.out.println(jedi.fight());

	}
}
