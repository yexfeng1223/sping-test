package com.gsoft.tx;

public interface BookShopDao {

    public int findBookPriceByIsBn(String isBn);

    public void updateBookStore(String isBn);

    public void updateUserAccount(String username,int price);
}
