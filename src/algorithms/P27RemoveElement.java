package algorithms;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * Show Hint
 * <p>
 * Created by fjun on 4/16/16.
 */
public class P27RemoveElement {

    public int removeElementBetter(int[] nums, int val) {
        if (nums == null) return 0;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] != val) {
                start ++;
            } else if (nums[end] == val) {
                end --;
            } else {
                nums[start] = nums[end];
                start ++;
                end --;
            }
        }
        return start;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index ++] = num;
            }
        }
        return index;
    }
}
