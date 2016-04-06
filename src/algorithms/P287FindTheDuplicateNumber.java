package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Created by fjun on 4/5/16.
 */
public class P287FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 4, 3, 2, 2, 5}));
    }

    /**
     * 二分法：先计算小于n/2的数量 cnt；如果 cnt > n/2，则表示重复的数字出现在[0, n/2]范围内。
     * 再用同样的方法进一步缩小范围。
     */
    public static int findDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int cnt = 0;
            int mid = start + (end - start) / 2;
            for (int n : nums) {
                if (n <= mid) {
                    cnt ++;
                }
            }
            if (cnt > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int findDuplicateSpace(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return 0;
    }

}
