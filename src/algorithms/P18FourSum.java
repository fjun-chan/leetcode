package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d
 * in S such that a + b + c + d = target? Find all unique quadruplets
 * in the array which gives the sum of target.
 *
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * Created by fjun on 4/12/16.
 */
public class P18FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        final int imax = nums.length - 3;
        final int jmax = nums.length - 2;
        for (int i = 0; i < imax; i ++) {
            if (nums[i] << 2 > target) {
                break;
            }
            for (int j = i + 1; j < jmax; j ++) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do {
                            k ++;
                        } while(k < l && nums[k - 1] == nums[k]);
                        do {
                            l --;
                        } while (k < l && nums[l + 1] == nums[l]);
                    } else if (sum < target) {
                        do {
                            k++;
                        } while (k < l && nums[k - 1] == nums[k]);
                    } else {
                        do {
                            l--;
                        } while (k < l && nums[l + 1] == nums[l]);
                    }
                }
                while (j < jmax && nums[j + 1] == nums[j]) j ++;
            }
            while (i < imax && nums[i + 1] == nums[i]) i ++;
        }
        return result;
    }
}
