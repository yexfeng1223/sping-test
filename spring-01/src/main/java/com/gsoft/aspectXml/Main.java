package com.gsoft.aspectXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("bean-aop-config.xml");

        ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator)ctx.getBean("arithmeticCalculator");


        int result= arithmeticCalculator.add(1,2);
        System.out.println("--->"+result);

        result= arithmeticCalculator.sub(1,2);
        System.out.println("--->"+result);

        result= arithmeticCalculator.div(6,0);
        System.out.println("--->"+result);
    }

}
