package algorithms;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


 * Created by fjun on 4/5/16.
 */
public class P268MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int l = nums.length;
        return (1 + l) * l / 2 - sum;
    }
}
