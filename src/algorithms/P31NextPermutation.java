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
        int[] nums = {1,5,4,2};
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
        int pos = -1;
        for (int n = nums.length - 1; n > 0; n --) {
            if (nums[n] > nums[n-1]) {
                pos = n - 1;
                break;
            }
        }
        if (pos != -1) {
            int t = pos + 1;
            for (int n = nums.length - 1; n >= 0; n --) {
                if (nums[n] > nums[pos]) {
                    t = n;
                    break;
                }
            }
            nums[t] = nums[t] ^ nums[pos];
            nums[pos] = nums[t] ^ nums[pos];
            nums[t] = nums[t] ^ nums[pos];
        }

        int s = pos + 1;
        int e = nums.length - 1;
        while (s < e) {
            nums[s] = nums[s] ^ nums[e];
            nums[e] = nums[s] ^ nums[e];
            nums[s] = nums[s] ^ nums[e];
            s ++;
            e --;
        }
    }
}
