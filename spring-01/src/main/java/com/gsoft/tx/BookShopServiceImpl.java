package com.gsoft.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaofeng
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;



    @Transactional
    @Override
    public void purechase(String username, String isBn) {

      int price=  bookShopDao.findBookPriceByIsBn(isBn);

        bookShopDao.updateUserAccount(username,price);


        bookShopDao.updateBookStore(isBn);

    }
}
