package com.epam.botor.config;

import static com.epam.botor.domain.Color.RED;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.epam.botor.domain.LightSabre;

@Configuration
public class LightSabreConfiguration {

	@Bean(initMethod="init", destroyMethod="destroy2")
	@Primary
	@Scope("prototype")
	public LightSabre lightSabre() {
		LightSabre lightSabre = new LightSabre("red sabre", 100);
		return lightSabre;
	}
	
	@Bean(initMethod="init", destroyMethod="destroy2")
	@Scope("prototype")
	public LightSabre redSabre(@Value("${lightsabre.red.damage}") int damage) {
		LightSabre lightSabre = new LightSabre("red sabre", damage);
		lightSabre.setColor(RED);
		return lightSabre;
	}
}
