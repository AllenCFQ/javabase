package com.allenou.java.design.singleton;

/**
 * 单例模式 -- 懒汉式-线程安全
 *  优点：同SingletonLazyNTS，加锁了,线程安全
 *  缺点：synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
 */
public class SingletonLazyTS {
    private static SingletonLazyTS singletonLazyTS = null;
    private SingletonLazyTS(){
    }
    public static  synchronized  SingletonLazyTS getInstance(){
        if (singletonLazyTS == null) {
            singletonLazyTS = new SingletonLazyTS();
        }
        return singletonLazyTS;
    }
}
