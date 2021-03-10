package com.gsoft.SpringOne;

public class Car {
    private String name;
    private int  jz;

    public Car(String name, int jz) {
        this.name = name;
        this.jz = jz;
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                ", jz=" + jz +
                '}';
    }
}
