package com.allenou.java.base.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * hashmap （http://www.iteye.com/topic/754887?page=2#1658753）
 * http://www.iteye.com/topic/754887?page=2#1658753
 * 验证HashMap线程非安全
 * oyp
 */
public class HashMapTNS {
    //static ConcurrentHashMap<String,String> map = new ConcurrentHashMap();    // 线程安全，锁粒度最小
    //static Map<String,String> map = Collections.synchronizedMap(new HashMap()); // 线程安全，粒度小
    //static Hashtable<String,String> map = new Hashtable(); // 线程安全，hashtable 锁粒度大，悲观锁方式，粒度大。
    static Map<String, String> map = new HashMap(); // 线程非安全，无锁，并发会出现闭环现象
    static int N = 1000;
    static CountDownLatch startSignal = new CountDownLatch(1);//闭锁
    static CountDownLatch doneSignal = new CountDownLatch(N);
    static AtomicInteger count = new AtomicInteger();
    static long begintime;
    static long endtime;

    public static void main(String[] args) {
        /**
         * 1.new 1000 个线程，new完后同时做put操作
         * 2.put完之后，再输出结果
         * 3.并发put后，线程安全情况下应该输出size=1000
         * ps：两把闭锁，一把等待new完线程，另一把等待put完变量
         */
        for (int i = 0; i < N; i++) {
            final int j = i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        begintime = System.currentTimeMillis();
                        startSignal.await();//使当前线程在锁存器倒计数至零之前一直等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    map.put(Thread.currentThread().getId() + "" + j, "test");
                    doneSignal.countDown();
                }
            }).start();
        }
        startSignal.countDown();//递减锁存器的计数，如果计数到达零，则释放所有等待的线程
        try {
            doneSignal.await();
            endtime = System.currentTimeMillis();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done,size:" + map.size());
        System.out.println("time :" + (endtime - begintime) + "ms");
    }
}