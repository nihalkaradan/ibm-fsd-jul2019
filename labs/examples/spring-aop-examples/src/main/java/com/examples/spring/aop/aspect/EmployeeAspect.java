package com.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class EmployeeAspect {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);

	public EmployeeAspect() {
		System.out.println("instance created");
	}

	@Before("execution(* get*(..))")
	public void getNameAdvice() {
		logger.info("Executing Advice on getName()");
		System.out.println("This is injected from Employee Aspect 1 for getName ");
	}

//	@Before("execution(* com.examples.spring.aop.model.Employee.setName(..))")
////	@Before("execution(public String getName())")
//	public void getAllAdvice() {
//		logger.info("Executing Advice on setName and getName()");
//		System.out.println("This is injected from Employee Aspect 2");
//	}
}
