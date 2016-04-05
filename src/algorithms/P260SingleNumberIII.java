package algorithms;

import java.util.Arrays;
import java.util.HashSet;

/**
 *  Single Number III
 *
 *  Given an array of numbers nums, in which exactly two elements appear only once
 *  and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 *  For example:
 *  Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 *  Note:
 *  The order of the result is not important. So in the above example, [5, 3] is also correct.
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * Created by fjun on 4/4/16.
 */
public class P260SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 3, 1, 2, 5})));
    }

    public static int[] singleNumber(int[] nums) {
        int aXorB = 0;
        for (int n : nums) {
//            System.out.println(Integer.toBinaryString(n));
            aXorB ^= n;
        }
//        System.out.println("==============");
//        System.out.println(Integer.toBinaryString(aXorB));
//        System.out.println(Integer.toBinaryString(aXorB - 1));
//        System.out.println(Integer.toBinaryString(~(aXorB - 1)));
        int b = aXorB & (~(aXorB - 1));
//        System.out.println(Integer.toBinaryString(b));
//        System.out.println(b);
        int[] r = new int[]{0, 0};
        for (int n : nums) {
            if ((n & b) == 0) {
                r[0] ^= n;
            } else {
                r[1] ^= n;
            }
        }
        return r;
    }
}
