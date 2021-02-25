package com.allenou.java.base.thread;

public class ThreadInfoTest {
    public static void main(String[] args) {
        getCurProcessThreads();
    }
    /**
     * 获取当前进程的线程数、名称及相关信息
     * oyp
     */
    public static void getCurProcessThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        // 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
        // copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        System.out.println("Thread list size == " + list.length);
        for (Thread thread : list) {
            System.out.println(String.format("thread：" +
                            "Name:%s|" +
                            "Daemon:%s|" +
                            "State:%s|" +
                            "Id:%s|" +
                            "Priority:%s|" +
                            "ClassLoader:%s|" +
                            "isAlive:%s|" +
                            "StackTrace:%s|" +
                            "ThreadGroup:%s|" +
                            "Interrupted:%s|" +
                            "toString:%s|",
                    thread.getName(),
                    thread.isDaemon(),
                    thread.getState(),
                    thread.getId(),
                    thread.getPriority(),
                    thread.getContextClassLoader(),
                    thread.isAlive(),
                    thread.getStackTrace(),
                    thread.getThreadGroup(),
                    thread.isInterrupted(),
                    thread.toString()

            ));
        }
    }
}
