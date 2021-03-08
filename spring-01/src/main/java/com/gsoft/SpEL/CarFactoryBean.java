package com.gsoft.SpEL;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {


    @Override
    public Car getObject() throws Exception {
        return new Car("Audi",100000,200);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
