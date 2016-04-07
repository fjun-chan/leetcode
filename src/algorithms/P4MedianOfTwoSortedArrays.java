package algorithms;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Created by fjun on 4/7/16.
 */
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5}));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int len1 = nums1.length, len2 = nums2.length;
        final int n = ((len1 + len2) >> 1) + 1;
        int left = 0, right = 0;
        int i1 = 0, i2 = 0, searchCnt = 0;
        while (searchCnt < n) {
            left = right;
            if (i1 >= len1) {
                right = nums2[i2 ++];
            } else if (i2 >= len2) {
                right = nums1[i1 ++];
            } else {
                right = nums1[i1] > nums2[i2] ? nums2[i2 ++] : nums1[i1 ++];
            }
            searchCnt ++;
        }
        return (len1 + len2) % 2 == 0 ? (left + right) / 2.0 : right;
    }
}
