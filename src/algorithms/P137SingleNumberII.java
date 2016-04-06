package algorithms;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Created by fjun on 4/6/16.
 */
public class P137SingleNumberII {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,3,3,6}));
        System.out.println(singleNumberK(new int[]{3,3,3,3,5,5,5,5,10993030}, 4));
    }

    public static int singleNumberK(int[] nums, int k) {
        int res = 0;
        final int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 0x01;
            }
            res += (sum % k) << i;
        }
        return res;
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        final int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 0x01;
            }
            res += (sum % 3) << i;
        }
        return res;
    }

}
