package com.allenou.java.base.thread.threadbasics;

import sun.font.FontRunIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 面试题：
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程以及10个消费线程的阻塞调用
 *
 */
public class Mst01_thread {

    static  ArrayList<String> arrayList = new ArrayList<>(20);

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            arrayList.add(""+i);
        }
    }
}
