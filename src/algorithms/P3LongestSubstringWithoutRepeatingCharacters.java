package algorithms;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 *  which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Created by fjun on 4/3/16.
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("1234561789dd"));
        System.out.println(lengthOfLongestSubstring("c"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[255];
        int max = 0;
        final char[] cs = s.toCharArray();
        final int length = cs.length;
        int curStart = 0;
        int curEnd = -1;
        for (int i = 0; i < length; i ++) {
            int index = cs[i];
            int last = lastIndex[index];
            if (last == 0 || last < curStart) {
                curEnd = i;
            } else {
                int len = curEnd - curStart + 1;
                if (max < len) {
                    max = len;
                }
                curStart = last;
                curEnd ++;
            }
            lastIndex[index] = i + 1;
        }
        int len = curEnd - curStart + 1;
        if (max < len) {
            max = len;
        }
        return max;
    }
}
