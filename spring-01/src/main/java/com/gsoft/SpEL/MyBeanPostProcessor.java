package com.gsoft.SpEL;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author xiaofeng
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        System.out.println("postProcessBeforeInitialization...."+bean+"....."+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if(beanName.equals("car")){
//            bean=  new Car("BMW",12,13);
//        }
        System.out.println("postProcessAfterInitialization...."+bean+"....."+beanName);
        return bean;
    }
}
