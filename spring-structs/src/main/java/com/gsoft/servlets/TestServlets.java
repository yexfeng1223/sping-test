package com.gsoft.servlets;

import com.gsoft.bean.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlets extends HttpServlet {
    private static final long serialVersionUID = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute("ApplicationContext");

        Person person=   context.getBean(Person.class);
        person.hello();
        super.doGet(req, resp);
    }
}
