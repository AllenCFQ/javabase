package com.allenou.java.design.singleton;
/**
 * 单例模式 -- 懒汉式-线程安全
 *  优点：饿汉模式天生是线程安全的，使用时没有延迟。
 *  缺点：启动时即创建实例，启动慢，有可能造成资源浪费。
 */
public class SingletonHungry {
    private  static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){
    }
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
