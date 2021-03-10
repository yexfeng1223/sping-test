package com.gsoft.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserJDao extends JdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource( dataSource);
    }

    public User getUser(int i){
        String sql="select id,name,family,phoneNum from testUser where id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        return  getJdbcTemplate().queryForObject(sql,rowMapper,i);
    }

}
