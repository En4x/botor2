package com.epam.botor.config;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;

import com.epam.botor.beanpostprocessors.SayRiseBeanPostProcessor;
import com.epam.botor.converters.LightSabreConverter;
import com.epam.botor.domain.Fight;
import com.epam.botor.domain.FightEventHandler;
import com.epam.botor.domain.IonBlaster;
import com.epam.botor.domain.IonBlasterCannon;
import com.epam.botor.domain.IonBlasterPistol;
import com.epam.botor.domain.IonBlasterRifle;
import com.epam.botor.domain.RandomIonBlasterSimpleFactory;
import com.epam.botor.propertyeditors.MyStringTrimmerEditor;

@Configuration
@ImportResource("classpath:beans.xml")
@Import({ JediConfig.class, LightSabreConfiguration.class /*, ArmyConfig.class */})
@PropertySource("classpath:starwars.properties")
@ComponentScan(basePackages = { "com.epam.botor.domain", "com.epam.botor.aspects" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
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
		Set<Converter<?, ?>> converters = new HashSet<>();
		converters.add(new LightSabreConverter());
		conversionService.setConverters(converters);
		return conversionService;
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
	
	@Bean
	public Fight fight() {
		return new Fight();
	}
	
	@Bean
	public FightEventHandler fightEventHandler() {
		return new FightEventHandler();
	}
	
//    <bean id="randomIonBlaster" class="com.epam.botor.domain.IonBlaster" factory-bean="ionBlasterFactory" factory-method="produceIonBlaster" scope="prototype"/>
//	
//	<bean id="ionBlasterFactory" class="com.epam.botor.domain.RandomIonBlasterSimpleFactory">
//	 <lookup-method name="getIonBlasterPistol" bean="ionBlasterPistolRepo"/>
//	 <lookup-method name="getIonBlasterRifle" bean="ionBlasterRifleRepo"/>
//	 <lookup-method name="getIonBlasterCannon" bean="ionBlasterCannonRepo"/>
//	</bean>
//	
	@Bean
	public RandomIonBlasterSimpleFactory ionBlasterFactory(ApplicationContext context) {
		return new RandomIonBlasterSimpleFactory() {
			
			@Override
			public IonBlasterRifle getIonBlasterRifle() {
				return context.getBean("ionBlasterRifleRepo", IonBlasterRifle.class);
			}
			
			@Override
			public IonBlasterPistol getIonBlasterPistol() {
				return context.getBean("ionBlasterPistolRepo", IonBlasterPistol.class);
			}
			
			@Override
			public IonBlasterCannon getIonBlasterCannon() {
				return context.getBean("ionBlasterCannonRepo", IonBlasterCannon.class);			}
		};
	}
	
	@Bean
	@Scope("prototype")
	public IonBlaster randomIonBlaster(RandomIonBlasterSimpleFactory ionBlasterFactory ) {
		return ionBlasterFactory.produceIonBlaster();
	}
	
	
	@Bean
	@Scope("prototype")
	public IonBlaster ionBlasterPistolRepo() {
		return new IonBlasterPistol(10);
	}
	
	@Bean
	@Scope("prototype")
	public IonBlaster ionBlasterRifleRepo() {
		return new IonBlasterRifle(10);
	}

	@Bean
	@Scope("prototype")
	public IonBlaster ionBlasterCannonRepo() {
		return new IonBlasterCannon(10);
	}

	
	
}

