package com.allenou.java.base.thread.threadbasics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test_main {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();

        LongAdder longAdder  = new LongAdder();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.wait();
        LockSupport.park();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(20);

    }
}
