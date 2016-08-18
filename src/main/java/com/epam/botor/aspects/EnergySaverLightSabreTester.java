package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.LightSabre;

@Aspect
@Component
public class EnergySaverLightSabreTester {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnergySaverLightSabreTester.class);

//    @Before("com.epam.botor.aspects.EnergySaverLightSabreAspect.lightSabreInUse()")
//    @Order(200)
//    public void testSwitchedOnBefore(final JoinPoint joinPoint) {
//
//        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();
//        LOGGER.warn(joinPoint.getTarget().getClass().getName());
//        LOGGER.warn(joinPoint.getThis().getClass().getName());
//        LOGGER.warn("Switched on before use: " + targetLightSabre.isSwitchedOn());
//
//    }

    @After("com.epam.botor.aspects.EnergySaverLightSabreAspect.lightSabreInUse()")
    @Order(200)
    public void testSwitchedOnAfter(final JoinPoint joinPoint) {

        LightSabre targetLightSabre = (LightSabre) joinPoint.getTarget();

        LOGGER.warn("Switched on after use: " + targetLightSabre.isSwitchedOn());

    }
}
