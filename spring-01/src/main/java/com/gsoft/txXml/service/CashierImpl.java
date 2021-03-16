package com.gsoft.txXml.service;

import com.gsoft.txXml.impl.Cashier;

import java.util.List;

public class CashierImpl implements Cashier {
    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkOut(String username, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purechase(username,isbn);
        }
    }
}
