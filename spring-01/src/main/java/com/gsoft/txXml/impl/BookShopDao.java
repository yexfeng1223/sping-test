package com.gsoft.txXml.impl;

public interface BookShopDao {

    public int findBookPriceByIsBn(String isBn);

    public void updateBookStore(String isBn);

    public void updateUserAccount(String username, int price);
}
