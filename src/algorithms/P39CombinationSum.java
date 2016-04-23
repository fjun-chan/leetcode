package algorithms;

import java.util.*;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * Created by fjun on 4/23/16.
 */
public class P39CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1, 2}, 4));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> list = new ArrayList<>();
        search(list, new ArrayList<>(), candidates, 0, target);
        return list;
    }

    public static void search(List<List<Integer>> res, List<Integer> had, int[] array, int start, int target) {
        for (int i = start; i < array.length; i ++) {
            int num = array[i];
            int n = target / num;
            for (int j = n; j >= 1; j --) {
                List<Integer> list = addNTimes(had, num, j);
                int left = target - num * j;
                if (left == 0) {
                    res.add(list);
                } else {
                    search(res, list, array, i + 1, left);
                }
            }
        }
    }

    public static List<Integer> addNTimes(List<Integer> had, int num, int times) {
        List<Integer> list = new ArrayList<>(had);
        for(int i = 0; i < times; i ++) {
            list.add(num);
        }
        return list;
    }
}
