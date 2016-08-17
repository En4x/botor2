package com.epam.botor.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class FightEventHandler implements ApplicationListener<FightEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FightEventHandler.class);

	public void onApplicationEvent(FightEvent event) {
		LOGGER.debug("EVENT HAPPENED: " + event.toString());
	}

}