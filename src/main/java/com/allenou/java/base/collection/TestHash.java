package com.allenou.java.base.collection;

import jdk.internal.dynalink.beans.StaticClass;

public class TestHash {

    static String  key  = "key";

    public static void main(String[] args) {
        int h = key.hashCode();

        System.out.println(h);
        System.out.println(h >>> 16);
        System.out.println( (h = key.hashCode()) ^ (h >>> 16) );
    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
