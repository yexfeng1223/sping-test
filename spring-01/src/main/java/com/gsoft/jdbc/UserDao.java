package com.gsoft.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(int id){
        String sql="select id,name,family,phoneNum from testUser where id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        User user= jdbcTemplate.queryForObject(sql,rowMapper,1);
        //System.out.println(user);
        return  user;
    }
}
