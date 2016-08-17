package com.epam.botor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.botor.domain.Blaster;
import com.epam.botor.domain.BlasterPistol;
import com.epam.botor.domain.BlasterRifle;

@Configuration
public class BlasterConfiguration {

	@Bean
	public Blaster commonBlaster(@Value("blaster") String name, @Value("100") int damage) {
		return Math.random() > 0.5 ? new BlasterPistol(name, damage) : new BlasterRifle(name, damage);
	}
	
	@Bean
	@Scope("prototype")
	public BlasterPistol blasterPistol() {
		return new BlasterPistol("Blaster pistol", (int)(95 + Math.random() * 10));
	}
}
