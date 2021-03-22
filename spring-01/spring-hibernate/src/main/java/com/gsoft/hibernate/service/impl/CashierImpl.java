package com.gsoft.hibernate.service.impl;

import java.util.List;

import com.gsoft.hibernate.service.BookShopService;
import com.gsoft.hibernate.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CashierImpl implements Cashier {
	
	@Autowired
	private BookShopService bookShopService;
	
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
