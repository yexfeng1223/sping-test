package com.gsoft.SpEL;

public class HelloWorld {
    private String name;
    private String city;
    private Car car;
    private String info;


    public HelloWorld() {
        System.out.println("构造函数....");
    }

    public void  init(){
        System.out.println("hello init() .....");

    }

    public void destroy(){
        System.out.println("hello destroy().....");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setname.....");
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", car=" + car +
                ", info='" + info + '\'' +
                '}';
    }
}
