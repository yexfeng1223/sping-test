package com.gsoft.txXml.service;

import com.gsoft.tx.BookShopDao;
import com.gsoft.txXml.BookStoreException;
import com.gsoft.txXml.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author xiaofeng
 */
public class BookShopDaoImpl implements  BookShopDao {

    private  JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findBookPriceByIsBn(String isBn) {
        String sql="select price from book where isbn=?";
        int price=jdbcTemplate.queryForObject(sql,Integer.class,isBn);
        return price;
    }

    @Override
    public void updateBookStore(String isBn) {
            String sql = "select stock from book_store where isbn=?";
            int stock = jdbcTemplate.queryForObject(sql, Integer.class, isBn);
            if (stock <= 0) {
                throw new BookStoreException("-----库存不足！！！！！");
            }

            sql = "update book_store set stock=stock-1 where isBn=?";
            jdbcTemplate.update(sql, isBn);



    }

    @Override
    public void updateUserAccount(String username, int price) {
        String sql="select balance from account where username=?";
        int balance=jdbcTemplate.queryForObject(sql,Integer.class,username);
        if(balance<price){
            throw new UserAccountException("-----余额不足！！！！！");
        }

         sql="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,username);
    }
}
