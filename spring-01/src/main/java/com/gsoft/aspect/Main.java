package com.gsoft.aspect;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx= new ClassPathXmlApplicationContext("bean-config.xml");

        ArithmeticCalculator arithmeticCalculator=ctx.getBean(ArithmeticCalculator.class);

        int result= arithmeticCalculator.add(1,2);

        System.out.println("--->"+result);
    }
}
