package com.gsoft.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public void showUser(int i){
        System.out.println(dao.getUser(i));
    }
}
