package com.allenou.java.design.factory.factorymethod;

import com.allenou.java.design.factory.simplefactory.Benz;
import com.allenou.java.design.factory.simplefactory.Car;

public class BenzFactory implements Factory {
    public Car getCar() {
        return new Benz();
    }
}
