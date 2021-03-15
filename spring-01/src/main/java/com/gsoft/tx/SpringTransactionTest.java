package com.gsoft.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringTransactionTest {
    ApplicationContext ctx=null;
    BookShopDao bookShopDao=null;
    BookShopService bookShopService=null;
    Cashier cashier=null;

    {
        ctx=new ClassPathXmlApplicationContext("application-tx-config.xml");
        bookShopDao=ctx.getBean(BookShopDao.class);
        bookShopService=ctx.getBean(BookShopService.class);
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

    @Test
    public void testBookShopDaoFindPrice(){
        int bookPriceByIsBn = bookShopDao.findBookPriceByIsBn("1001");
        System.out.println(bookPriceByIsBn);
    }

    @Test
    public void testBookShopDaoUpdateStore(){
        bookShopDao.updateBookStore("1001");

    }

    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);

    }
}
