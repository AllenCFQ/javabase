package arithmetic;

import java.util.Arrays;

public class QuickSort02 {

    public static void main(String[] args) {
        int[] ints = {6, 7, 3, 9, 0, 1, 234, 6, 78, 8};
        quicksort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 快速排序
     *
     * 数据结构
     * 1. 一个数组
     * 算法：
     * 2. 确定基点，确定左索引、右索引；遍历完整之后，左（基）与 左索引位置交换，一遍之后满足 左 < 基 < 右
     * 3. 左，基 遍历
     * 4. 右，基 遍历
     * 5. 递归终止 left > right
     *
     * 程序=数据结构+算法
     */
    public static void quicksort(int[] args,int left,int right) {

        if (left > right) {
            return ;
        }
        int base = args[left];
        int i = left;
        int j= right;
        while ( i < j) {
            while (args[j] >= base && i < j) {
                j--;
            }
            while (args[i] <= base && i < j ) {
                i++;
            }
            if (i < j) {
                int temp = args[j];
                args[j]=args[i];
                args[i]=temp;
            }
        }
        args[left]=args[i];
        args[i]=base;

        quicksort(args,left,i-1);
        quicksort(args,i+1,right);
    }
}
