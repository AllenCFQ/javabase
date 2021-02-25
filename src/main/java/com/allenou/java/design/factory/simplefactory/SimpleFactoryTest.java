package com.allenou.java.design.factory.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Car car = simpleFactory.getCar("BMW");
        System.out.println(car.getName());
    }
}
