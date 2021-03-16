package com.gsoft.txXml.impl;

import java.util.List;

public interface Cashier {

    public void checkOut(String username, List<String> isbns);

    interface BookShopService {

        public  void purechase(String username, String isBn);
    }
}
