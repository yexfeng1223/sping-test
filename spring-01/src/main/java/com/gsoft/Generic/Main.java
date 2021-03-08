package com.gsoft.Generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");
        UserService userService=(UserService) context.getBean("userService");
        userService.add();
    }
}
