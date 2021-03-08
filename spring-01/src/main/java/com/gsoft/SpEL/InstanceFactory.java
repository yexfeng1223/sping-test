package com.gsoft.SpEL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaofeng
 */
public class InstanceFactory {

    private Map<String,Car> map=null;

    public InstanceFactory() {
        this.map = new HashMap<>();
        Car car1=new Car("Audi",400000,20);
        Car car2=new Car("DzZ",400000,20);
        Car car3=new Car("BMW",400000,20);

        map.put("Audi",car1);
        map.put("DzZ",car2);
        map.put("BMW",car3);
    }

    public  Car getCar(String carName){
        return  map.get(carName);
    }

}
