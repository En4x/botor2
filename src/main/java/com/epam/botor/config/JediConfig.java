package com.epam.botor.config;

import static com.epam.botor.domain.Gender.MALE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.botor.domain.Jedi;
import com.epam.botor.domain.LightSabre;

@Configuration
public class JediConfig {

	@Bean
	public Jedi darthVader(LightSabre lightSabre) {
		Jedi darthVader = new Jedi("Darth Vader", MALE);
		darthVader.setLightSabre(lightSabre);
		return darthVader;
	}


}
