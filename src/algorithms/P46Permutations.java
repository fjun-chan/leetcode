package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * Created by fjun on 25/05/16.
 */
public class P46Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        addToList(list, nums);
        while (true) {
            int pos = nums.length - 1;
            while (pos > 0 && nums[pos] <= nums[pos - 1]) {
                pos--;
            }
            if (pos == 0) {
                break;
            }
            int t = nums.length - 1;
            while (t > 0 && nums[t] <= nums[pos - 1]) {
                t--;
            }
            swap(nums, t, pos - 1);
            reverse(nums, pos, nums.length - 1);
            addToList(list, nums);
        }
        return list;
    }

    private static void addToList(List<List<Integer>> list, int[] nums) {
        List<Integer> l = new ArrayList<>(nums.length);
        list.add(l);
        for (int n : nums) {
            l.add(n);
        }
    }

    private static void reverse(int[] a, int f, int t) {
        while (f < t) {
            swap(a, f, t);
            f ++;
            t --;
        }
    }
    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}
