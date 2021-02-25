package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 4, 5, 7, 8, 9};
        System.out.println(Arrays.toString(twoSum2(nums, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
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


    public static int[] twoSum2(int[] nums, int target) {
        int[] result = {};
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                result = new int[]{map.get(target - nums[i]), i};
                arrayList.add(map.get(target - nums[i]));
                arrayList.add(i);
            }
        }
        result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }


    public int[] twoSum03(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);

            if(j != null) {
                return new int[]{j, i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}