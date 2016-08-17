package com.epam.botor.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;

import com.epam.botor.beanpostprocessors.SayRiseBeanPostProcessor;
import com.epam.botor.converters.LightSabreConverter;
import com.epam.botor.propertyeditors.MyStringTrimmerEditor;

@Configuration
@ImportResource("classpath:beans.xml")
@Import({ JediConfig.class, LightSabreConfiguration.class, ArmyConfig.class })
@PropertySource("classpath:starwars.properties")
@ComponentScan(basePackages = "com.epam.botor.domain")
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
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer result = new PropertySourcesPlaceholderConfigurer();
		result.setFileEncoding("UTF-8");
		return result;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public Locale locale(@Value("${locale.lang}") String lang, @Value("${locale.country}") String country) {
		return new Locale(lang, country);
	}
}
