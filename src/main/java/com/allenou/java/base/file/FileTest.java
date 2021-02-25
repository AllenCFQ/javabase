package com.allenou.java.base.file;



import java.io.*;
import java.util.*;

public class FileTest {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader("c:\\Users\\12804\\Desktop\\SVN\\009_生产问题\\20201106鉴权问题优化\\日志.txt"));
        String line = read.readLine();
        Map<String,String > map = new HashMap<String, String>();



        while (line != null) {
           // System.out.println(line);
            String[]  strs = line.trim().split(" ");

            String value = map.get(strs[1]+strs[2]);
            if (value != null && value != "") {
                map.put(strs[1]+strs[2],""+(Integer.parseInt(strs[0])+Integer.parseInt(value)));

            } else {
                map.put(strs[1]+strs[2],strs[0]);
            }

            if ( strs[1] !=null && !"".equals( strs[1]) ) {
                if (  map.get(strs[1]+"总笔数") == null ) {
                    map.put(strs[1]+"总笔数",strs[0]);
                } else {
                    map.put(strs[1]+"总笔数",""+( Integer.parseInt(strs[0])+Integer.parseInt(map.get(strs[1]+"总笔数"))));
                }

            }



            line = read.readLine();
        }

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("认证成功");
        Map<String,LinkedList> result = new HashMap<String, LinkedList>();
        for (String key : map.keySet()) {
           //System.out.println(key+ ","+ map.get(key));
           System.out.println(key.substring(16,24)+","+key.substring(24)+ ","+ map.get(key));

            if ( key.contains("认证成功") )  {
                linkedList.add( key.substring(16,24) +","+map.get(key));
            }
        }

       // System.out.println(linkedList.toArray().toString());

        for (String s:linkedList) {
            //System.out.print(s+",");
        }




    }
}
