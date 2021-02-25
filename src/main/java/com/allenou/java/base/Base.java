package com.allenou.java.base;

import com.sun.deploy.util.ArrayUtil;
import sun.awt.SunHints;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.locks.Condition;

public class Base {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//
//        testSet();
//        testHashMap();
        testLamada();

    }

    public static void testSet () {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer i:treeSet) {
            System.out.println(i);
        }

        Iterator<Integer> de = treeSet.descendingIterator();
        while (de.hasNext()){
            System.out.println(de.next());
        }

    }

    public static void testHashMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("xxoo","ooxx");
        map.forEach((key,value)->{
            System.out.println(key+value);
        });


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("lamada"+i);
            }
        }).start();

        Arrays.toString(new int[10]);
    }

    public static void  testLamada() {
        List<Integer> instList = Arrays.asList(123,1,2332,222,1,5,7,8);
        instList.stream().filter((e) -> e > 10).forEach(System.out::println);
        instList.stream().limit(4).forEach(System.out::println);
    }

}
