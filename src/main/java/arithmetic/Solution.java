package arithmetic;

import java.util.ArrayList;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        ArrayList<Integer> ints = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints.add(i);
                    ints.add(j);
                }
            }
        }
        int[] result = new int[ints.size()];
        for (int i = 0; i < ints.size(); i++) {
            result[i] = ints.get(i);
        }
        return result;
    }
}