package com.gsoft.txXml;

import com.gsoft.tx.BookShopDao;
import com.gsoft.txXml.impl.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {
    ApplicationContext ctx=null;
    BookShopDao bookShopDao=null;
    Cashier.BookShopService bookShopService=null;
    Cashier cashier=null;

    {
        ctx=new ClassPathXmlApplicationContext("application-tx-xml.config.xml");
        bookShopDao=ctx.getBean(BookShopDao.class);
        bookShopService=ctx.getBean(Cashier.BookShopService.class);
        cashier=ctx.getBean(Cashier.class);
    }

    @Test
    public void testMultiPureChase(){
        cashier.checkOut("AA", Arrays.asList("1002","1001"));
    }

    @Test
    public void testPureChase(){
        bookShopService.purechase("AA","1001");
    }

}
