package com.allenou.java.base.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 使用ManagementFactory.getThreadMXBean()获取死锁线程
 * oyp
 */
public class DeadLockTest {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        DeadLockThread t1 = new DeadLockThread(obj1, obj2);
        t1.start();

        DeadLockThread t2 = new DeadLockThread(obj2, obj1);
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MonitorThread mt = new MonitorThread();
        mt.start();
    }
}

class MonitorThread extends Thread {
    public void run() {
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        long[] ids = tmx.findDeadlockedThreads();
        if (ids != null) {
            ThreadInfo[] infos = tmx.getThreadInfo(ids, true, true);
            System.out.println("The following threads are deadlocked:");
            for (ThreadInfo ti : infos) {
                System.out.println(ti);
            }
        }
        ThreadInfo[] threads = tmx.getThreadInfo(tmx.getAllThreadIds());
        for (ThreadInfo ti : threads) {
            // System.out.println(ti.getStackTrace());
            for (StackTraceElement selm : ti.getStackTrace()) {
                System.out.println(selm + "---");
            }
        }

    }
}

class DeadLockThread extends Thread {
    private Object obj1;
    private Object obj2;

    public DeadLockThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        synchronized (obj1) {
            try {
                Thread.sleep(1000);
                synchronized (obj2) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}