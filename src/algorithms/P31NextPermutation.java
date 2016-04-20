package algorithms;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Created by fjun on 4/20/16.
 */
public class P31NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 1,5,4,2 -> 2,5,4,1 -> 2,1,4,5
     * 5,4,1,2 -> 5,4,2,1 -> 5,4,2,1
     * 1,2,4,5 -> 1,2,5,4
     * 2,1,5,4 -> 2,4,1,5
     */
    public static void nextPermutation(int[] nums) {
        int pos = nums.length - 1;
        while(pos > 0 && nums[pos] <= nums[pos - 1]) { pos --;}
        if (pos == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int t = nums.length - 1;
        while(t > 0 && nums[t] <= nums[pos - 1]) { t --; }
        swap(nums, t, pos - 1);
        reverse(nums, pos, nums.length - 1);
    }

    private static void reverse(int[] a, int f, int t) {
        while (f < t) {
            swap(a, f, t);
            f ++;
            t --;
        }
    }
    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
