package com.allenou.java.mianshiti;

/**
 * 两个有序链表合并成一个有序链表
 */
public class TwoListOrder {
    public static void main(String[] args) {
        int[] one = {1,2,3};
        int[] two = {4,5};

        int indexOne = 0;
        int indexTwo = 0;
        /**
         * 1. 两个指针 指向两个有序数组
         * 2. 分别遍历 两个数组
         * 3. 谁小就放进新链表，小的指针+1
         * 如此循环
         */
        while (true) {

            if ( indexOne == one.length && indexTwo == two.length ) {
                break;
            }
            if ( one[indexOne] > two[indexTwo] ) {
                System.out.println(two[indexTwo]);
                if (indexTwo ==two.length -1) {
                    System.out.println(two[indexOne]);
                    indexOne++;
                    if (indexOne==one.length) {
                        indexTwo++;
                    }
                } else {
                    indexTwo++;
                }
                continue;
            }

            if( one[indexOne] < two[indexTwo]) {
                System.out.println(one[indexOne]);
                if (indexOne ==one.length -1) {
                    System.out.println(two[indexTwo]);
                    indexTwo++;
                    if (indexTwo==two.length) {
                        indexOne++;
                    }
                } else {
                    indexOne++;
                }
                continue;
            }



        }

    }
}
