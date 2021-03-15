package com.gsoft.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
    ApplicationContext ctx=null;
    BookShopDao bookShopDao=null;
    BookShopService bookShopService=null;

    {
        ctx=new ClassPathXmlApplicationContext("application-tx-config.xml");
        bookShopDao=ctx.getBean(BookShopDao.class);
        bookShopService=ctx.getBean(BookShopService.class);
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
