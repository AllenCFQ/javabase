package com.allenou.java.design.singleton;

/**
 * 单例 -懒汉方式-线程非安全
 *  Lazy load Thread Not Safe
 *  优点：懒加载启动快，资源占用小，使用时才实例化，无锁。
 * 缺点：非线程安全。
 */
public class SingletonLazyNTS {
    private static SingletonLazyNTS singletonLazyNTS = null;
    private SingletonLazyNTS(){
    }
    public static SingletonLazyNTS getInstance(){
        if (singletonLazyNTS == null) {
            singletonLazyNTS = new SingletonLazyNTS();
        }
        return singletonLazyNTS;
    }
}
