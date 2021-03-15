package com.gsoft.tx;

import java.util.List;

public interface Cashier {

    public void checkOut(String username, List<String> isbns);
}
