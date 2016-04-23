package algorithms;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p>
 * Created by fjun on 4/23/16.
 */
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsertBt(new int[]{1,3,5,6}, 0));
        System.out.println(searchInsertBt(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsertBt(new int[]{1,3,5,6}, 4));
        System.out.println(searchInsertBt(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsertBt(new int[]{1,3,5,6}, 7));
    }

    public static int searchInsertBt(int[] nums, int target) {
        return searchInner(nums, 0, nums.length - 1, target);
    }
    public static int searchInner(int[] nums, int from, int to, int target) {
        if (target <= nums[from]) {
            return from;
        }
        final int t = nums[to];
        if (target == t) {
            return to;
        }
        if (target > t){
            return to + 1;
        }
        final int mid = (from + to) / 2;
        final int m = nums[mid];
        if (target == m) {
            return mid;
        }
        if (mid == from) {
            return mid + 1;
        }
        if (m < target) {
            return searchInner(nums, mid, to, target);
        }
        return searchInner(nums, from, mid, target);
    }

    public static int searchInsert(int[] nums, int target) {
        final int len = nums.length;
        for (int i = 0; i < len; i ++) {
            int num = nums[i];
            if (num >= target) {
                return i;
            }
        }
        return len;
    }
}
