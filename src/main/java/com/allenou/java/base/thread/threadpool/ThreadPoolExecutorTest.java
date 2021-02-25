package com.allenou.java.base.thread.threadpool;

import com.sun.jmx.snmp.tasks.Task;

import java.util.concurrent.*;

/**
 * 1、corePoolSize 线程池常驻核心线程数
 * 创建线程池后，当有请求任务来之后，就会安排池中线程去执行请求任务，近似理解为今日当值线程。
 * 当线程池中的线程数目达到了corePoolSize后，就会把任务放到缓存队列中；
 * 2、maxmumPoolSize；
 * 线程池能够容纳同时执行的最大线程数，此值必须大于等于1；
 * 3、keepAliveTime：多余空闲线程的存活时间;
 * 当前线程池的数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，多余空闲线程会被销毁直到只剩下corePoolSize个线程为止。
 * 4、unit:keepAliveTime的时间单位
 * 5、workQueue：任务队列，被提交但未被执行的任务
 * 6、threadFactory：表示生成线程池中线程的线程工厂，用于创建线程，一般用默认的即可
 * 7、handler：拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数（maxmumPoolSize）
 *
 * 模拟银行办理业务窗口数为线程池中线程数量来进行运行
 *
 * @Date 2020-11-03 13:37:40
 * @Author oyp
 */
public class ThreadPoolExecutorTest {

    public static   ThreadPoolExecutor executorService;

    public static  void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();//获取CPU核心线程数
        System.out.println(processors);
        /**
         * 创建线程池并给定初始参数
         *
         * @param corePoolSize 核心线程数量，即使处于空闲状态，也保留在池中的线​​程数，
         *                     除非设置了{@code allowCoreThreadTimeOut}
         * @param maximumPoolSize 最大线程数量
         * @param keepAliveTime 空闲线程存活时间
         * @param unit 时间单位
         * @param workQueue 创建阻塞队列，一定声明长度，不然默认会是Integer.MAX_VALUE
         * @param threadFactory 一般情况都是用默认的线程工厂来创建线程
         * @param handler 当容量达到上限时的拒绝策略
         */
           executorService = new ThreadPoolExecutor(
                2,//核心线程数量
                /*processors*/5,//最大线程数量
                2,//空闲线程存活时间
                TimeUnit.SECONDS,//时间单位
                new LinkedBlockingQueue(3),//创建阻塞队列，一定声明长度，不然默认会是Integer.MAX_VALUE
                Executors.defaultThreadFactory(),//一般情况都是用默认的线程工厂来创建线程
                new ThreadPoolExecutor.AbortPolicy()//默认拒绝策略，丢弃任务并抛出RejectedExecutionException异常。
//                new ThreadPoolExecutor.CallerRunsPolicy()//将任务回退给调用者
//                new ThreadPoolExecutor.DiscardPolicy()//不执行任何操作,丢弃线程
                // new ThreadPoolExecutor.DiscardOldestPolicy()//丢弃线程中的旧的任务
        );
        //Mylog(executorService.toString());

        try {
            ThreadPoolExecutorTest tpeTest = new ThreadPoolExecutorTest();
            for (int i = 0; i < 10; i++) {
                try {
                    executorService.execute(tpeTest.new Task(""+i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void Mylog(String str) {
        System.out.println(str);
    }

    public static void monitor() {
        Thread monitor = new Thread(){
            @Override
            public void run() {
                while (true){
                    Mylog(executorService.toString());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        monitor.start();
    }

    /**
     * 任务类
     */
    class Task implements  Runnable {
        private String name;

        public Task(String name ) {
            this.name = name;
        }
        public void run() {
            Mylog( toString()+"办理业务，需要5秒钟！");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public String toString() {
            return Thread.currentThread().getName()+";"+super.toString()+"; name:"+name ;
        }
    }


    /**
     * 工作中不可能用这种方式创建线程池，
     * 这种方式很容易会发生OOM（out of memory）内存溢出的情况，
     * 从源码中可以看出阻塞队列的长度为Integer的最大数，阿里巴巴开发手册已经规定，
     * 不可以使用Executors.new的方式来创建线程池
     */
    
//    public void testExecutor() {
//        //线程池通过Executors工具类来获取
////        ExecutorService executorService = Executors.newFixedThreadPool(5);//固定线程数量
////        ExecutorService executorService = Executors.newSingleThreadExecutor();//线程数量为1
//        ExecutorService executorService = Executors.newCachedThreadPool();//自动通过缓存获取线程，线程数量为N
//
//        try {
//            for (int i = 0; i < 10; i++) {
//                executorService.execute(new Runnable() {
//                    public void run() {
//                        System.out.println(Thread.currentThread().getName() + "\t 办理服务！");
//                    }
////                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
//    }

}

