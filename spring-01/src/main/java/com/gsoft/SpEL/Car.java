package com.gsoft.SpEL;

public class Car {
    private String brand;
    private double price;
    private double typrePermeter;

    public Car() {
        System.out.println("构造函数 car");
    }

    public void destroy(){
        System.out.println("Car destroy().....");
    }

    public void  init(){
        System.out.println("Car init() .....");

    }


    public Car(String brand, double price, double typrePermeter) {
        this.brand = brand;
        this.price = price;
        this.typrePermeter = typrePermeter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTyprePermeter() {
        return typrePermeter;
    }

    public void setTyprePermeter(double typrePermeter) {
        this.typrePermeter = typrePermeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", typrePermeter=" + typrePermeter +
                '}';
    }
}
