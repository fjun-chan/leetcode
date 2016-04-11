package algorithms;

import java.util.*;

/**
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * Created by fjun on 4/11/16.
 */
public class P15ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum18ms(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,
                -6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,
                14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,
                0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum18ms(new int[]{0, 0}));
    }

    /**
     * 先排序，再固定一个值，然后，加两个指针分别从前往后、从后往前扫描。
     * 这里，需要注意处理数字相同的情况。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i ++) {
            int target = - nums[i];
            int front = i + 1;
            int end = nums.length - 1;
            while (front < end) {
                if (nums[front] + nums[end] == target) {
                    result.add(Arrays.asList(-target, nums[front], nums[end]));
                    do {
                        front++;
                    } while (front < end && nums[front - 1] == nums[front]);
                    do {
                        end--;
                    } while (front < end && nums[end + 1] == nums[end]);
                } else if (nums[front] + nums[end] < target) {
                    front++;
                } else {
                    end--;
                }
            }
            while(i < nums.length-2 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }

    public static List<List<Integer>> threeSum18ms(int[] nums) {
        List<Integer> keys = new ArrayList<Integer>(nums.length);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int n : nums) {
            Integer had = map.get(n);
            if (had == null) {
                map.put(n, 1);
                keys.add(n);
            } else {
                map.put(n, had + 1);
            }
        }
        Collections.sort(keys);
        int len = keys.size();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < len; i ++) {
            int k = keys.get(i);
            if (k > 0) {
                break;
            }
            int v = map.get(k);
            if (k == 0) {
                if (v >= 3) {
                    result.add(Arrays.asList(k, k, k));
                }
                break;
            }
            if (v >= 2 && map.containsKey(0 - k - k)) {
                result.add(Arrays.asList(k, k, 0 - k - k));
            }
            for (int j = i + 1; j < len; j ++) {
                int o1 = keys.get(j);
                int o2 = 0 - k - o1;
                if (o2 < o1 || !map.containsKey(o2) || o1 == o2 && map.get(o1) < 2) {
                    continue;
                }
                result.add(Arrays.asList(k, o1, o2));
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumTLE(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>(3);
        for (int i = 0; i < nums.length; i ++) {
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            for (int j = 0; j < nums.length; j ++) {
                if (i == j) {
                    continue;
                }
                int iv = nums[i], jv = nums[j];
                int c = 0 - iv - jv;
                if (m.containsKey(c)) {
                    List<Integer> l = Arrays.asList(iv, jv, c);
                    Collections.sort(l);
                    result.add(l);
                }
                m.put(jv, j);
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
