
# Java多线程：
### 1.请用示例说明java.lang.ThreadGroup有哪些使用场景?

https://blog.csdn.net/qq_35995514/article/details/90714422
https://www.cnblogs.com/zyguo/p/4350568.html

### 2.请描述如何使用的多线程？


### 3.线程池的7大参数？  com.allenou.java.base.thread.threadpool.ThreadPoolExecutorTest

1、corePoolSize 线程池常驻核心线程数
创建线程池后，当有请求任务来之后，就会安排池中线程去执行请求任务，近似理解为今日当值线程。
当线程池中的线程数目达到了corePoolSize后，就会把任务放到缓存队列中；  
2、maxmumPoolSize；  
线程池能够容纳同时执行的最大线程数，此值必须大于等于1；  
3、keepAliveTime：多余空闲线程的存活时间;  
当前线程池的数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，多余空闲线程会被销毁直到只剩下corePoolSize个线程为止。
4、unit:keepAliveTime的时间单位  
5、workQueue：任务队列，被提交但未被执行的任务  
6、threadFactory：表示生成线程池中线程的线程工厂，用于创建线程，一般用默认的即可  
7、handler：拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数（maxmumPoolSize）


