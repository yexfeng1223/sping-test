package com.gsoft.aspectXml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

public class LoggingAspect {

   public void declareJoinPointExpression(){}

    public void beforeMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        List<Object> args= Arrays.asList(joinPoint.getArgs()) ;

        System.out.println("the method  "+methodName+" begins with args is "+args);
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" after ");
    }

    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" after return is  "+result);
    }

    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("the method  "+methodName+" afterThrowing ex "+ex);
    }

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
