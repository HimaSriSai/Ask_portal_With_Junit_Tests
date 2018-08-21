package com.prokarma.common.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AskAspectClass {

	 private static final Logger LOGGER = Logger.getLogger(AskAspectClass.class);

	@Around("@annotation(com.prokarma.common.util.Ask_AOP)")
	public Object employeeAround(ProceedingJoinPoint proceedingJoinPoint) {

		LOGGER.info("Method Initiated");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			LOGGER.info(e.getMessage());
		}

		LOGGER.info("End of Method");
		return value;

	}

}
