package com.epam.botor.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class FightEvent extends ApplicationEvent {
	
	public FightEvent(Object source) {
		super(source);
	}

	public String toString(){
	      return "My Custom Event";
	   }
}
