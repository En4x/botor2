package com.epam.botor.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.epam.botor.domain.Jedi;

public class SayRiseBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Jedi) {
			System.out.printf("%s RAISED!!!!\n", ((Jedi)bean).getName());
		}
		return bean;
	}
	
	

}
