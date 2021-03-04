package com.gsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context= new  ClassPathXmlApplicationContext("HelloWorldConfig.xml");
        HelloWorld hd=(HelloWorld) context.getBean("helloWorld");
        hd.hello();

        HelloWorld hd2=(HelloWorld) context.getBean("helloWorld");
        hd2.hello();
        HelloWorld hd3=(HelloWorld) context.getBean("helloWorld");
        hd3.hello();

        DataSource dataSource=(DataSource)context.getBean("datasource1");
        System.out.println(dataSource.getConnection());
    }

}
