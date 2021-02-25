package com.allenou.java.base.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FileTest2 {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader("c:\\Users\\12804\\Desktop\\SVN\\009_生产问题\\20201106鉴权问题优化\\result.txt"));
        String line = read.readLine();
        Map<String, String> map = new HashMap<String, String>();

//        LinkedList<String> linkedList = new LinkedList<String>();
//        LinkedList<String> linkedList = new LinkedList<String>();
//        LinkedList<String> linkedList = new LinkedList<String>();
//        LinkedList<String> linkedList = new LinkedList<String>();
//        LinkedList<String> linkedList = new LinkedList<String>();
//        LinkedList<String> linkedList = new LinkedList<String>();
        while (line != null) {
            String[] strs = line.trim().split(",");
            String begin = map.get(strs[1]);
            String end = strs[0]+","+strs[2];
            String key = strs[1];
            map.put(key,begin+"-"+end);
            line = read.readLine();
        }


        for (String key : map.keySet()) {
            System.out.println(key+ ","+ map.get(key));

        }






    }
}
