package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fjun on 4/23/16.
 */
public class P40CombinationSumII {
    public static void main(String[] args){
//        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum(new int[]{1}, 1));
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
        for (int i = start; i < array.length; ) {
            int num = array[i];
            if (num > target) {
                return;
            }
            int left = target - num;
            if (left > 0) {
                if (i == array.length - 1) return;
                int next = array[i + 1];
                if (next > left) {
                    search(res, had, array, i + 1, target);
                    return;
                }
            }

            List<Integer> list = new ArrayList<>(had);
            list.add(num);
            if (left == 0) {
                res.add(list);
            } else {
                search(res, list, array, i + 1, left);
            }
            do {
                i++;
            }while(i < array.length && array[i] == num);
        }
    }
}
