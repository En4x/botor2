package com.epam.botor.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import com.epam.botor.beanpostprocessors.SayRiseBeanPostProcessor;
import com.epam.botor.converters.LightSabreConverter;
import com.epam.botor.propertyeditors.MyStringTrimmerEditor;

@Configuration
@ImportResource("classpath:beans.xml")
@Import({ JediConfig.class, LightSabreConfiguration.class })
public class StarWarsConfig {

	@Bean
	public CustomEditorConfigurer customEditorConfigurer() {
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
		customEditors.put(String.class, MyStringTrimmerEditor.class);
		customEditorConfigurer.setCustomEditors(customEditors);
		
		return customEditorConfigurer;
	}
	
	@Bean
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean conversionService = new ConversionServiceFactoryBean();
		conversionService.setConverters(converters());
		return conversionService;
	}
	
	@Bean
	public Set<Converter<?, ?>> converters() {
		Set<Converter<?, ?>> converters = new HashSet<>();
		converters.add(new LightSabreConverter());
		return converters;
	}
	
	@Bean
	public SayRiseBeanPostProcessor sayRiseBeanPostProcessor() {
		return new SayRiseBeanPostProcessor();
	}
	
}
