package com.allenou.java.design.factory.factorymethod;

import com.allenou.java.design.factory.simplefactory.BMW;
import com.allenou.java.design.factory.simplefactory.Car;

public class BMWFactory implements Factory {
    public Car getCar() {
        return new BMW();
    }
}
