package com.epam.botor.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class Fight {
	private static final Logger LOGGER = LoggerFactory.getLogger(Fight.class);
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void fight() {
		LOGGER.debug("I'm figthing");
		publisher.publishEvent(new FightEvent(this));
		LOGGER.debug("Figthing ended.");
	}

}