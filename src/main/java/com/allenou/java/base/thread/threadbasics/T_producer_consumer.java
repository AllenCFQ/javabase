package com.allenou.java.base.thread.threadbasics;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 *
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 *
 * @author oyp
 */

public class T_producer_consumer<T> {
    private final LinkedList<T> list = new LinkedList<>();
    final  private  int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try  {
            lock.lock();
            while (list.size() ==MAX) {
                producer.wait();
            }
            list.add(t);
            //++count;
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  T get() {
        T t = null;
        try {
            lock.lock();
            while (list.size() ==0) {
                consumer.await();
            }
            t = list.removeFirst();
            //count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {

        T_producer_consumer<String> c = new T_producer_consumer<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println("消费："+c.get());
                }
            }
            ).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread( ()-> {
                for (int j = 0; j < 25; j++) {
                    System.out.println("生产 : "+Thread.currentThread().getName()+" "+j);
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            }).start();
        }

    }

    










}
