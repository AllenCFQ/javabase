package com.allenou.java.design.singleton;

/**
 * 单例模式 -- 枚举-线程安全
 * 优点：直接通过Singleton.INSTANCE.doSomething()的方式调用即可。方便、简洁又安全。
 * 为什么说枚举是做好的Java单例实现方法？ https://www.jianshu.com/p/d9d9dcf23359
 *
 * */

public enum SingletonEnum {
    INSTANCE;
    public void doSomething() {
        System.out.println("doSomething");
    }
}

class Main {
    public static void main(String[] args) {
        /**
         * 调用
         */
        SingletonEnum.INSTANCE.doSomething();
    }
}
