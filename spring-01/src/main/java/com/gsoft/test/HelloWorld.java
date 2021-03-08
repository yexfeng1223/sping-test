package com.gsoft.test;


import java.util.List;
import java.util.Map;

public class HelloWorld {
    private String name;
    private String address;
    private Car car;

    private List<Car> cars;

    private Map<String,Car> carMap;

    private DataSource dataSource;

    public HelloWorld() {
        System.out.println("HelloWorld ..........");
    }

    public HelloWorld(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public void hello(){
        System.out.println("Hello world:"+name+" from Address "+address+" car is"+car+" cars="+cars +" map="+carMap+"\r\n datasource="+dataSource);
    }

    @Override
    public String toString() {
        return "HelloWord{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}