package arithmetic;

import sun.security.ssl.Debug;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 随机选取基点： 一次下来， 左边数 < 基点 < 右边数
 * 左边数,随机选取几点：  左边的数[  左边（左边数） < 基点（左边数）< 右边（左边数）]
 * 右边数,随机选取几点：  左边的数[  左边（右边数） < 基点（右边数）< 右边（右边数）]
 * 如此循环下去 循环到 左坐标 > 右坐标 终止。
 * 老外： https://www.programcreek.com/2012/11/quicksort-array-in-java/ ，难理解
 * 2021-02-03 18:14:32
 * 抽出几点：
 * 1.递归结束条件。
 * 2.只使用一个容器，数据不断调换。
 * 3.不断确定左坐标，右坐标。
 */
public class Quicksort {

    public static final boolean DEBUG = false;

    public static void main(String[] args) {
        int[] ints01 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints02 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ints03 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ints04 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ints05 = new int[]{10, 6, 4, 8, 7, 3, 2, 1, 5, 9};
        int[] ints06 = new int[]{6, 4, 8, 7, 3, 2, 1, 5, 9};
        test(ints01);
        test(ints02);
        test(ints03);
        test(ints04);
        test(ints05);
        test(ints06);
    }

    public static void test(int[] array) {
        System.out.println("before array = [" + Arrays.toString(array) + "]");
        quickSort(array, 0, array.length - 1);
        System.out.println("after array = [" + Arrays.toString(array) + "]");
    }

    public static void quickSort(int[] array, int left, int right) {
        // 递归终止条件
        if (left > right) {
            return;
        }
        // 确定索引和基点
        int i = left;
        int j = right;
        // 遍历一遍完之后，i 位置需要与left位置交换
        int base = array[left];
        log("基点：" + base);
        while (i < j) {

            // 选择左left为基点，那么从右边遍历
            // 因为如果从左边开始遍历，那么左边索引最终停留的位置比base大， 最终i位置需要与left（即base）位置交换，不满足遍历后 左边 < base < 右边
            // 所以要从右边开始遍历
            while (array[j] >= base && i < j) {
                j--;
            }

            while (array[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                // 交换虽然简单，但不能错
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            log(array);
        }

        // 选取的基点 与 一遍遍历结束后的i交换
        array[left] = array[i];
        array[i] = base;
        // 继续分而治之
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    public static void log(int[] args) {
        if (DEBUG) {
            System.out.println("args = " + Arrays.toString(args)+ "");
        }
    }

    public static void log(String args) {
        if (DEBUG) {
            System.out.println(args);
        }
    }
}
