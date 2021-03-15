package com.gsoft.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xiaofeng
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements  BookShopDao {

    @Autowired
    private  JdbcTemplate jdbcTemplate;



    @Override
    public int findBookPriceByIsBn(String isBn) {
        String sql="select price from book where isbn=?";
        int price=jdbcTemplate.queryForObject(sql,Integer.class,isBn);
        return price;
    }

    @Override
    public void updateBookStore(String isBn) {
        String sql="select stock from book_store where isbn=?";
        int stock=jdbcTemplate.queryForObject(sql,Integer.class,isBn);
        if(stock<=0){
            throw new BookStoreException("-----余额不足！！！！！");
        }

        sql="update book_store set stock=stock-1 where isBn=?";
        jdbcTemplate.update(sql,isBn);
    }

    @Override
    public void updateUserAccount(String username, int price) {
        String sql="select balance from account where username=?";
        int balance=jdbcTemplate.queryForObject(sql,Integer.class,username);
        if(balance<=price){
            throw new UserAccountException("-----库存不足！！！！！");
        }

         sql="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,username);
    }
}
