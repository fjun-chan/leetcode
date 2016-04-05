package algorithms;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

 * Created by fjun on 4/5/16.
 */
public class P169MajorityElement {

    public static void main(String[] args) {

    }

    // Moore's majority vote method
    public static int majorityElement(int[] nums) {
        // From: https://leetcode.com/discuss/95639/java-hashmap-sorting-and-moores-majority-vote-solutions
        int majority = 0;
        int votes = 0;
        for (int n : nums) {
            if (votes == 0) {
                majority = n;
            }
            if (majority == n) {
                votes ++;
            } else {
                votes --;
            }
        }
        return  majority;
    }
}
