package com.epam.botor.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.epam.botor.domain.LoudNess;
import com.epam.botor.domain.Person;

@Aspect
@Component
public class MakeItLoudAspect {

    @Around(
            value = 
            	"execution (String com.epam.botor.domain.Person.battleCry(com.epam.botor.domain.LoudNess)) && "
            	+ "args(loudNess) && target(targetPerson)",
            argNames = "targetPerson,loudNess")
    public String makeItLoud(final ProceedingJoinPoint joinPoint, final Person targetPerson, final LoudNess loudNess) throws Throwable {

        String result = (String) joinPoint.proceed();

        if (loudNess == LoudNess.HIGH) {
            result = result.toUpperCase();
        }

        return result;

    }

}
