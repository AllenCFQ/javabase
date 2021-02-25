package com.allenou.java.design.factory.abstractfactory;

import com.allenou.java.design.factory.simplefactory.Benz;
import com.allenou.java.design.factory.simplefactory.Car;

public class BenzFactory extends AbstractFactory {
    protected Car getCar() {
        return new Benz();
    }
}
