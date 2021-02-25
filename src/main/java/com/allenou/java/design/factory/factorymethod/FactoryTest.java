package com.allenou.java.design.factory.factorymethod;

public class FactoryTest {
    public static void main(String[] args) {
        Factory bwmFactory = new BMWFactory();
        System.out.println(bwmFactory.getCar().getName());
        Factory benzFactory = new BenzFactory();
        System.out.println(benzFactory.getCar().getName());
    }
}
