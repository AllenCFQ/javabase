package com.allenou.java.design.factory.simplefactory;

public class SimpleFactory {
    public Car getCar(String name) {
        if (name.equals("BMW")) {
            return  new BMW();
        } else if (name.equals("Benz")){
            return new Benz();
        } else {
            System.out.println("不好意思，这个品牌汽车生产不了");
            return null;
        }


    }
}
