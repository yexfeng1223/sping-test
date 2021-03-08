package com.gsoft.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(1)
@Aspect
@Component
public class ValidateAspect {
    @Before("LoggingAspect.declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
       List<Object> list= Arrays.asList(joinPoint.getArgs());
        System.out.println("--->validate before "+methodName+" is runing  with "+list);
    }
}
