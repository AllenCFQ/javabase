package com.allenou.java.design.factory.abstractfactory;

import com.allenou.java.design.factory.factorymethod.BMWFactory;
import com.allenou.java.design.factory.factorymethod.BenzFactory;
import com.allenou.java.design.factory.simplefactory.Car;

public abstract  class AbstractFactory {
    protected  abstract Car getCar();

    public Car getCar (String name ) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new BMWFactory().getCar();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new BenzFactory().getCar();
        } else {
            System.out.println("这个产品生产不了");
            return null;
        }
    }
}
