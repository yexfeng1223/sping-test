package com.gsoft.jdbc;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate;
    private UserDao dao;
    private UserJDao jDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx=new ClassPathXmlApplicationContext("applicationContest-jdbc.xml");
        jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        dao=ctx.getBean(UserDao.class);
        jDao=ctx.getBean(UserJDao.class);
        namedParameterJdbcTemplate=ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    @Test
    public void testNamedParameterJdbcTemplate(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("ln",5);
        String sql="select id,name,family,phoneNum from testUser where id <=:ln";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        List<User> users= namedParameterJdbcTemplate.query(sql,map,rowMapper);
        System.out.println(users);
    }

    @Test
    public void testNamedParameterJdbcTemplateUpdate(){
        String sql="insert into testUser(id,name,family,phoneNum) values(:id,:name,:family,:phoneNum)";
        User user=new User();
        user.setId(6);
        user.setName("pp");
        user.setFamily("aaa");
        user.setPhoneNum("121212121221");
        SqlParameterSource sqlParameterSource=new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

    @Test
    public void testUserDao(){
        System.out.println(dao.getUser(1));
    }

    @Test
    public void testUserJDao(){
        System.out.println(jDao.getUser(2));
    }

    @Test
    public void testListObject(){
        String sql="select id,name,family,phoneNum from testUser where id>?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        List<User> users= (List<User>) jdbcTemplate.query(sql,rowMapper,1);
        System.out.println(users);
    }

    @Test
    public void testQueryForObj2(){
        String sql="select count(id) from testUser";
        long count=jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    @Test
    public void testUpdate(){
        String sql="update biz_consumer set name=? where id=?";
        jdbcTemplate.update(sql,"yefeng",7);
    }




    @Test
    public void testQuaryForObject(){
        String sql="select id,name,family,phoneNum from testUser where id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        User user= jdbcTemplate.queryForObject(sql,rowMapper,1);
       // User user= jdbcTemplate.queryForObject(sql,1,User.class);
        System.out.println(user);

    }

    @Test
    public void testBatchUpdate(){
        String sql="insert into testUser(id,name,family,phoneNum) values(?,?,?,?)";
        List<Object[]> batArgs=new ArrayList<>();
        batArgs.add(new Object[]{1,"叶小风","family","18362653566"});
        batArgs.add(new Object[]{2,"叶小风","family","18362653566"});
        batArgs.add(new Object[]{3,"叶小风","family","18362653566"});
        batArgs.add(new Object[]{4,"叶小风","family","18362653566"});
        batArgs.add(new Object[]{5,"叶小风","family","18362653566"});

        jdbcTemplate.batchUpdate(sql,batArgs);

    }


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

}
