package org.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.shop.*.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("{}. {} is running.", joinPoint.getSignature().getDeclaringTypeName(),
                                          joinPoint.getSignature().getName());
    }


}

