package com.epam.botor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutTesterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PointcutTesterAspect.class);

    @Before("testPointcut1()")
    public void logBefore(final JoinPoint joinPoint) {

        String targetObjectClassName = joinPoint.getTarget().getClass().getSimpleName();

        LOGGER.warn(targetObjectClassName + " matched! - " + System.identityHashCode(joinPoint.getTarget()));

    }

    @Pointcut("execution (* com.epam.botor.domain.Weapon.shoot(..))")
    private void testPointcut1() {
    }

    @Pointcut("execution (* shoot(..)) && within(com.epam.botor.domain.*)")
    private void testPointcut2() {
    }

    @Pointcut("execution (* shoot(..)) && target(com.epam.botor.domain.Weapon)")
    private void testPointcut3() {
    }

    @Pointcut("execution (* shoot(..)) && this(com.epam.botor.domain.Weapon)")
    private void testPointcut4() {
    }

    @Pointcut("@target(com.epam.botor.annotations.Blessed) && execution (* shoot(..))")
    private void testPointcut5() {
    }

    @Pointcut("@within(com.epam.botor.annotations.Blessed) && execution (* shoot(..))")
    private void testPointcut6() {
    }

    @Pointcut("@annotation(com.epam.botor.annotations.Blessed)")
    private void testPointcut7() {
    }

    /**
     * Does NOT work at initialization time
     */
    @Pointcut("execution (* setDamage(..))")
    private void testPointcut8() {
    }

    @Pointcut("execution (* setDamage(..)) && args(int)")
    private void testPointcut9() {
    }

    @Pointcut("execution (* com.epam..*.setDamage(..))")
    private void testPointcut10() {
    }

    /**
     * Won't work since we can not put annotation on "int"
     */
    @Pointcut("execution (* com.epam..*.setDamage(..)) && @args(com.epam.botor.annotations.Blessed)")
    private void testPointcut() {
    }

}
