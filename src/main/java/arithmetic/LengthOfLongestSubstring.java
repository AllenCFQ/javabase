package arithmetic;

import javax.management.MXBean;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.TreeSet;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println("======");
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println("======");
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println("======");
        System.out.println(lengthOfLongestSubstring2(""));
        System.out.println("======");
        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println("======");
    }

    /**
     * 数据结构：
     * 1.如何存放子串，长度（1.map检测重复。 2.map存放结果）
     * 算法：
     * 1.拆分成子串（两次for循环）
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s==null || "".equals(s)) {
            return 0;
        }
        HashMap<String, Integer> map1 = new HashMap<>();
        TreeSet<Integer> integers = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {

            String temp = s.charAt(i)+"";
            map1.put(temp+"",i);
            for ( int j = i+1;j<s.length();j++) {
                String temp2 = s.charAt(j)+"";

                if (map1.get(temp2+"") ==null) {
                    temp += s.charAt(j)+"";
                    map1.put(temp2+"",i);
                } else {
                    System.out.println(temp+":"+temp.length());
                    integers.add(temp.length());
                    map1.clear();
                    break;
                }
            }
            System.out.println(temp+":"+temp.length());
            integers.add(temp.length());
            map1.clear();

        }
        return integers.last();
    }

    public static int lengthOfLongestSubstring2(String s) {
        int begin,end,maxlength=0;

        for (begin=0,end=1;end <= s.length(); end ++) {
           String str = s.substring(begin,end);

           if (end != s.length()) {
               int repeat = str.indexOf(s.charAt(end));
               if (repeat != -1) {
                   begin += repeat +1;
               }
           }
           if (str.length() > maxlength) {
               maxlength = str.length();
           }
            System.out.println(str+":"+str.length());
        }
        return maxlength;
    }
}
