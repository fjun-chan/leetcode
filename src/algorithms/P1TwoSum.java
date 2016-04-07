package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * <p>
 * <p>
 * Created by fjun on 4/7/16.
 */
public class P1TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0,6,7,3,5,0}, 0)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int v = nums[i];
            Integer h = map.get(target - v);
            if (h != null) {
                return new int[]{i, h};
            }
            map.put(v, i);
        }
        return null;
    }

    public static int[] twoSumN2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
