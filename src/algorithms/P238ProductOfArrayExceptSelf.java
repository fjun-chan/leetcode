package algorithms;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Created by fjun on 4/5/16.
 */
public class P238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    /**
     * 思路：将数组分成[0,k-1], [k], [k, n]三部分。先从右往左计算[k,n]的积，再从左往右计算[0, k-1]的积。
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i --) {
            res[i] = right;
            right *= nums[i];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i ++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}
