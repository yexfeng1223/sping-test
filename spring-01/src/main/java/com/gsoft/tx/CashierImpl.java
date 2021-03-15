package com.gsoft.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkOut(String username, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purechase(username,isbn);
        }
    }
}
