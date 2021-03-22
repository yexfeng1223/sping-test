package com.gsoft.hibernate.test;


import com.gsoft.hibernate.service.BookShopService;
import com.gsoft.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

public class TestHibernate {
    ApplicationContext ctx=null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;
    {
        ctx=new ClassPathXmlApplicationContext("application-hibernate-config.xml");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void TestDataSource() throws SQLException {
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testCashier(){
        cashier.checkout("yefeng", Arrays.asList("1001","1002"));
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("yefeng", "1001");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
