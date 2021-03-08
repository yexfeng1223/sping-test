package com.gsoft.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int com.gsoft.aspect.ArithmeticCalculator.*(int,int)) ")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs()) ;

        System.out.println("the method  "+methodName+" begins with args is "+args);
    }

    @After("execution(public int com.gsoft.aspect.ArithmeticCalculator.*(int,int) )")
    public void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" after ");
    }

    @AfterReturning(value = "execution(public int com.gsoft.aspect.ArithmeticCalculator.*(int,int))",
            returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" after return is  "+result);
    }

    @AfterThrowing(value = "execution(public int com.gsoft.aspect.ArithmeticCalculator.*(int,int))",
            throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" afterThrowing ex "+ex);
    }

    @Around("execution(public int com.gsoft.aspect.ArithmeticCalculator.*(int,int) )")
    public  Object AroundMethod(ProceedingJoinPoint pjt){
        System.out.println("AroundMethod.....");
        Object result=null;
        try{
            System.out.println("the AroundMethod doing.....");
            result=pjt.proceed();

        }  catch (Throwable throwable) {
            System.out.println("ex is "+throwable);
            result=1000;
        } finally {

        }

        return result;
    }
}
