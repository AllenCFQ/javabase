package com.allenou.java.design.factory.abstractfactory;

import com.allenou.java.design.factory.simplefactory.BMW;
import com.allenou.java.design.factory.simplefactory.Car;

public class BMWFactory extends  AbstractFactory {
    protected Car getCar() {
        return new BMW();
    }
}
