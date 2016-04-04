package algorithms;

/**
 * Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Created by fjun on 4/4/16.
 */
public class P136SingleNumber {


    public static int singleNumber(int[] nums) {
        int r = 0;
        for (int i : nums) {
            r ^= i;
        }
        return r;
    }
}
