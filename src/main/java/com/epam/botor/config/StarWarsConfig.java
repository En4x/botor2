package com.epam.botor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JediConfig.class)
public class StarWarsConfig {

	
}
