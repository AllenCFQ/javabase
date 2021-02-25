package com.allenou.java.base.jvm;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class T01 {
    public static void main(String[] args) throws InterruptedException {

        Object o = null;
        for(double i=0; i<100000_0000; i++) {
            o = new Object();
            //业务处理
        }



    }

}
