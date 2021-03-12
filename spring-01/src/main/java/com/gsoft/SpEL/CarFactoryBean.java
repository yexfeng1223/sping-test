package com.gsoft.SpEL;

import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

public class CarFactoryBean implements FactoryBean<Car> {
    private Map<String,Car> map=null;
    {
        this.map = new HashMap<>();
        Car car1=new Car("Audi",400000,20);
        Car car2=new Car("DzZ",400000,20);
        Car car3=new Car("BMW",400000,20);

        map.put("Audi",car1);
        map.put("DzZ",car2);
        map.put("BMW",car3);

    }

    @Override
    public Car getObject() throws Exception {
        return map.get("Audi");
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
