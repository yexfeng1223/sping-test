package com.gsoft.struts2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.applet.AppletContext;

public class SpringServiceContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        String config=servletContext.getInitParameter("contextConfigLocation");

        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);

        servletContext.setAttribute("ApplicationContext",ctx);

    }
}
