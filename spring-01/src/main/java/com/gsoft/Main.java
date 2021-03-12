package com.gsoft;

import com.gsoft.SpEL.Address;

import com.gsoft.SpEL.Car;
import com.gsoft.SpEL.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context= new  ClassPathXmlApplicationContext("SpringSpELConfig.xml");

//            Car car3=(Car)context.getBean("carFactoryBean");
//        System.out.println("factory bean ....."+car3);

//
//            Car car2=(Car)context.getBean("car2");
//        System.out.println("instance factory...."+car2);


//        Car car1=(Car)context.getBean("car1");
//        System.out.println("static factory ...."+car1);

//
//        Address address=(Address) context.getBean("address");
//        System.out.println(address);
//
//        Car car=(Car) context.getBean("car");
//        System.out.println(car);
//
        HelloWorld helloWorld =(HelloWorld)context.getBean("helloWorld");
        HelloWorld helloWorld2 =(HelloWorld)context.getBean("helloWorld");
        helloWorld2.setInfo("AAAA");

        System.out.println(helloWorld);
        System.out.println(helloWorld2);
        System.out.println(helloWorld==helloWorld2);
        context.close();
//        HelloWorld hd2=(HelloWorld) context.getBean("helloWorld");
//        hd2.hello();
//        HelloWorld hd3=(HelloWorld) context.getBean("helloWorld");
//        hd3.hello();
//
//        DataSource dataSource=(DataSource)context.getBean("datasource1");
//        System.out.println(dataSource.getConnection());


    }

}
