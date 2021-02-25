package com.allenou.java.design.factory.abstractfactory;

import com.allenou.java.design.factory.simplefactory.Benz;
import com.allenou.java.design.factory.simplefactory.Car;

public class DefaultFactory extends  AbstractFactory {

    private BenzFactory defaultFactory = new BenzFactory();

    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
