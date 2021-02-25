package com.allenou.java.design.singleton;

/**
 * 单例模式 -- 懒汉式-线程安全-双重检查
 *  优点：同SingletonLazyNTS，但加锁了,线程安全
 *  缺点：synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
 */
public class SingletonLazyDCC {
    private volatile static SingletonLazyDCC singletonLazyDCC = null;
    private SingletonLazyDCC(){
    }
    public static SingletonLazyDCC getInstance(){
        if (singletonLazyDCC == null) {
            synchronized(SingletonLazyDCC.class) {
                if (singletonLazyDCC == null) {
                    singletonLazyDCC = new SingletonLazyDCC();
                }
            }
        }
        return singletonLazyDCC;
    }
}
