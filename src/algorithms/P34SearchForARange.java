package algorithms;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * Created by fjun on 4/23/16.
 */
public class P34SearchForARange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
    public static int[] searchRange(int[] nums, int target) {
        return searchInner(nums, 0, nums.length - 1, target);
    }

    private static int[] searchInner(int[] nums, int from, int to, int target) {
        if (nums[from] == target && nums[to] == target) {
            return new int[]{from, to};
        }
        final int mid = (from + to) / 2;
        if (from == mid) {
            if (target == nums[from]) {
                return new int[]{from, from};
            } else if (target == nums[to]) {
                return new int[]{to, to};
            } else {
                return new int[]{-1, -1};
            }
        }
        final int m = nums[mid];
        if (m < target) {
            return searchInner(nums, mid, to, target);
        }
        if (m > target) {
            return searchInner(nums, from, mid, target);
        }
        int[] smaller = searchInner(nums, from, mid, target);
        int[] larger = searchInner(nums, mid, to, target);
        return new int[]{smaller[0], larger[1]};
    }
}
