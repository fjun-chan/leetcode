package algorithms;

import java.util.Arrays;

/**
 * Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by fjun on 4/4/16.
 */
public class P283MoveZeroes {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int searchIndex = 0;
        int fillIndex = 0;
        final int end = nums.length;
        while(searchIndex < end) {
            int cur = nums[searchIndex];
            if (cur != 0) {
                nums[fillIndex ++] = cur;
            }
            searchIndex ++;
        }
        while (fillIndex < end) {
            nums[fillIndex ++] = 0;
        }
    }
}
