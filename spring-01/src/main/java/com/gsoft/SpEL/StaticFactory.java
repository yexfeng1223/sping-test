package com.gsoft.SpEL;

import java.util.HashMap;
import java.util.Map;

public class StaticFactory {

    private static Map<String,Car>  map=new HashMap<>();

    static {
        Car car1=new Car("Audi",400000,20);
        Car car2=new Car("DzZ",400000,20);
        Car car3=new Car("BMW",400000,20);

        map.put(car1.getBrand(),car1);
        map.put(car2.getBrand(),car2);
        map.put(car3.getBrand(),car3);
    }

    public static Car getCar(String carName){
        return  map.get(carName);
    }

}
