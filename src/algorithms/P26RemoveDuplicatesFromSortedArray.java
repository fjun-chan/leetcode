package algorithms;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Created by fjun on 4/16/16.
 */
public class P26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int pre = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (pre != nums[i]) {
                nums[cnt++] = nums[i];
            }
            pre = nums[i];
        }
        return cnt;
    }
}
