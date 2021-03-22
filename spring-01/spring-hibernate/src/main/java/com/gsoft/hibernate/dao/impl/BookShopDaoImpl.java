package com.gsoft.hibernate.dao.impl;

import com.gsoft.hibernate.exception.BookStoreException;
import com.gsoft.hibernate.exception.UserAccountException;
import com.gsoft.hibernate.dao.BookShopDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    private  Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "SELECT b.price FROM com.gsoft.hibernate.entities.Book b WHERE b.isbn = ?0";
        Query query = getSession().createQuery(hql).setParameter(0, isbn);
        return (Integer)query.uniqueResult();
    }

    @Override
    public void updateBookStock(String isbn) {
        //验证书的库存是否充足.
        String hql2 = "SELECT b.stock FROM com.gsoft.hibernate.entities.Book b WHERE b.isbn = ?0";
        int stock = (int) getSession().createQuery(hql2).setParameter(0,isbn).uniqueResult();
        if(stock == 0){
            throw new BookStoreException("库存不足!");
        }

        String hql = "UPDATE com.gsoft.hibernate.entities.Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?0";
        getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够
        String hql2 = "SELECT a.balance FROM com.gsoft.hibernate.entities.Account a WHERE a.username = ?0";
        int balance = (int) getSession().createQuery(hql2).setParameter(0, username).uniqueResult();
        if(balance < price){
            throw new UserAccountException("余额不足!");
        }

        String hql = "UPDATE com.gsoft.hibernate.entities.Account a SET a.balance = a.balance - ?0 WHERE a.username = ?1";
        getSession().createQuery(hql).setParameter(0, price).setParameter(1, username).executeUpdate();
    }

}
