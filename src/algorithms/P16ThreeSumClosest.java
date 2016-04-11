package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Created by fjun on 4/11/16.
 */
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        int flag = 0;
        for (int i = 0; i < nums.length - 2; i ++) {
            int front = i + 1;
            int end = nums.length - 1;
            while (front < end) {
                int sum = nums[i] + nums[front] + nums[end];
                if (sum == target) {
                    return target;
                }

                int curDiff = Math.abs(sum - target);
                if (curDiff < diff) {
                    diff = curDiff;
                    closest = sum;
                }
                if (sum < target) {
                    flag = -1;
                    do {
                        front ++;
                    } while (front < end && nums[front - 1] == nums[front]);
                } else {
                    flag = 1;
                    do {
                        end --;
                    } while (front < end && nums[end + 1] == nums[end]);
                }
            }
            while(i < nums.length-2 && nums[i+1] == nums[i]) i++;
        }
        return closest;
    }
}
